package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    MyAccountPage myAccountObject;
    UserLoginPage loginObjects;

    String oldPassword= "123456";
    String newPassword= "101010101";
    String FN = "Moaz";
    String LN = "Adel";
    String email = "moazadel1125@Yahoo.com";

    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() {
        homeObjects = new HomePage(driver);
        homeObjects.openRegistrationPage();
        registerObjects = new UserRegistrationPage(driver);
        registerObjects.userRegistration(FN, LN, email, oldPassword);
        Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void registeredUserCanChangePassword() throws InterruptedException {
        myAccountObject = new MyAccountPage(driver);
        registerObjects.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword, newPassword);
        Thread.sleep(1000);
//        Assert.assertTrue(myAccountObject.successChangePasswordMessage.getText().contains("was changed"));
    }

    @Test(dependsOnMethods = "registeredUserCanChangePassword")
    public void registeredUserCanLogout() throws InterruptedException {
        registerObjects.userLogOut();
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = "registeredUserCanLogout")
    public void registeredUserCanLogIn() {

        homeObjects.userLogin();
        loginObjects = new UserLoginPage(driver);
        loginObjects.userLogin("moazadel1125@Yahoo.com",newPassword);
        Assert.assertTrue(registerObjects.myAccountLink.getText().contains("My account"));
    }
}
