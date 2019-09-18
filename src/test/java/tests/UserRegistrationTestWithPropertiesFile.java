package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithPropertiesFile extends TestBase {

    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    UserLoginPage loginObjects;

    String firstName = LoadProperties.userData.getProperty("firstname");
    String lastName  = LoadProperties.userData.getProperty("lastname");
    String email  = LoadProperties.userData.getProperty("email");
    String password  = LoadProperties.userData.getProperty("pass");


    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObjects = new HomePage(driver);
        homeObjects.openRegistrationPage();
        registerObjects = new UserRegistrationPage(driver);
        registerObjects.userRegistration(firstName, lastName, email, password);
        Thread.sleep(1000);
        Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
        registerObjects.userLogOut();
        homeObjects.userLogin();
        loginObjects = new UserLoginPage(driver);
        loginObjects.userLogin(email,password);
        registerObjects.userLogOut();
    }

}
