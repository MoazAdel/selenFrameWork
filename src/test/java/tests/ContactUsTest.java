package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
    HomePage home;
    ContactUsPage contactPage;

    String email = "test@test.com";
    String fullName = "Moaz Adel";
    String enquiry = "Hello iam testing you website";

    @Test
    public void userCanUseContactUs() {
        try {
            home = new HomePage(driver);
            home.openContactUsPage();
            contactPage = new ContactUsPage(driver);
            contactPage.submitContactUs(fullName, email, enquiry);
            Assert.assertTrue(contactPage.successMessage.getText().contains(" has been successfully sent to the store"));
        } catch (Exception e) {
            System.out.println("Error Occurred" + e.getMessage());
        }
        }
}
