package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParallel extends TestBase2 {
    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    UserLoginPage loginObjects;

    Faker fakeData = new Faker();
    String fName = fakeData.name().firstName();
    String lName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String pass  = fakeData.number().digits(8).toString();

    @Test()
    public void userCanRegisterSuccessfully() {
        homeObjects = new HomePage(getDriver());
        homeObjects.openRegistrationPage();
        registerObjects = new UserRegistrationPage(getDriver());
        registerObjects.userRegistration(fName,lName,email,pass);
        System.out.println("Username is : " + fName + " " + lName + " and Email is : " + email + "and password is : " + pass);
        Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
        registerObjects.userLogOut();

        homeObjects.userLogin();
        loginObjects = new UserLoginPage(getDriver());
        loginObjects.userLogin(email,pass);

        registerObjects.userLogOut();
    }
}
