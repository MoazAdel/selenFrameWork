package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

        HomePage homeObj;
        UserRegistrationPage registerObj;

        @Given("^The user in the home page$")
        public void the_user_in_the_home_page() {
                homeObj = new HomePage(driver);
                homeObj.openRegistrationPage();
        }


        @When("^He clicks on Register link$")
        public void the_user_clicks_on_Register_link() {
                Assert.assertTrue(driver.getCurrentUrl().contains("register"));
        }



        @Then("^The registration page displayed successfully$")
        public void theRegistrationPageDisplayedSuccessfully() {
                registerObj.userLogOut();
        }


        @And("He entered {string} , {string} , {string} , {string}")
        public void heEntered(String arg0, String arg1, String arg2, String arg3) {
                registerObj = new UserRegistrationPage(driver);
                registerObj.userRegistration(arg0,arg1,arg2,arg3);
        }
}
