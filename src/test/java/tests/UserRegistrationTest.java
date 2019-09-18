package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    UserLoginPage loginObjects;

    public String email = "moazadel1122@Yahoo.com";
    public String pass = "123456";

    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() {
        homeObjects = new HomePage(driver);
        homeObjects.openRegistrationPage();
        registerObjects = new UserRegistrationPage(driver);
        registerObjects.userRegistration("Moaz","Adel",email,pass);
        Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
    }
    @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void registeredUserCanLogout() {
        registerObjects.userLogOut();
    }

    @Test(dependsOnMethods = "registeredUserCanLogout")
    public void registeredUserCanLogIn() {

        homeObjects.userLogin();
        loginObjects = new UserLoginPage(driver);
        loginObjects.userLogin(email,pass);
    }
}
