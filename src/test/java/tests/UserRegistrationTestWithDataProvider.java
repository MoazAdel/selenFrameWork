package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDataProvider extends TestBase {

    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    UserLoginPage loginObjects;


    @DataProvider(name = "testData")
    public static Object[][] userData() {
        return new Object[][] {
                {
                    "Moaz", "Adel", "testval12@gmwwail.com","123456"
                },
                {
                    "Wezza", "Medhat","testval22@gwwmail.com" ,"123456789"
                }
        };
    }

    @Test(priority = 1,alwaysRun = true, dataProvider = "testData")
    public void userCanRegisterSuccessfully(String fName, String lName, String email, String pass) {
        homeObjects = new HomePage(driver);
        homeObjects.openRegistrationPage();
        registerObjects = new UserRegistrationPage(driver);
        registerObjects.userRegistration(fName,lName,email,pass);
        Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
        registerObjects.userLogOut();
        homeObjects.userLogin();
        loginObjects = new UserLoginPage(driver);
        loginObjects.userLogin(email,pass);
        registerObjects.userLogOut();
    }


}
