package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationTestUsingExcel extends TestBase {

    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    UserLoginPage loginObjects;


    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
        //Get data From Excel Reader Class
        ExcelReader ER = new ExcelReader();
        return ER.getExcelData();
    }


    @Test(priority = 1,alwaysRun = true, dataProvider = "ExcelData")
    public void userCanRegisterSuccessfully(String fName, String lName, String email, String pass) {
        homeObjects = new HomePage(driver);
        homeObjects.openRegistrationPage();
        registerObjects = new UserRegistrationPage(driver);
        registerObjects.userRegistration(fName, lName, email, pass);
        Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
        registerObjects.userLogOut();
        homeObjects.userLogin();
        loginObjects = new UserLoginPage(driver);
        loginObjects.userLogin(email,pass);
        registerObjects.userLogOut();
    }



}
