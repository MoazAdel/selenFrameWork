package tests;

import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithCSV extends TestBase {

    HomePage homeObjects;
    UserRegistrationPage registerObjects;
    UserLoginPage loginObjects;
    CSVReader reader;

    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() throws IOException {
        // get path of CSV
        String csv_file = System.getProperty("user.dir" + "/src/test/java/data/userData2.csv");
        String filename;
        reader = new CSVReader(new FileReader(csv_file));

        String[] csvCell;
        //While loop will be executed till the last value in the CSV File
        while ((csvCell = reader.readNext()) != null) {
            String fName = csvCell[0];
            String lName = csvCell[1];
            String email = csvCell[2];
            String pass = csvCell[3];

            //Registration Process
            homeObjects = new HomePage(driver);
            homeObjects.openRegistrationPage();
            registerObjects = new UserRegistrationPage(driver);
            registerObjects.userRegistration(fName, lName, email, pass);
            Assert.assertTrue(registerObjects.successMessage.getText().contains("completed"));
            registerObjects.userLogOut();
            //Login Process
            homeObjects.userLogin();
            loginObjects = new UserLoginPage(driver);
            loginObjects.userLogin(email, pass);
            registerObjects.userLogOut();
        }

    }

}
