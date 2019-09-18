package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase {

    HomePage homePageObjects;
    UserLoginPage loginPage;
    SearchPage searchPageObject;
    ProductDetailsPage productObject;
    EmailFriendPage emailFriendObjects;

    @Test
    public void userCanSendEmailToFriend() throws InterruptedException {
        homePageObjects = new HomePage(driver);
        homePageObjects.userLogin();
        Thread.sleep(1000);
        loginPage = new UserLoginPage(driver);
        loginPage.userLogin("moazadel3@gmail.com","101010");
        searchPageObject = new SearchPage(driver);
        searchPageObject.productSearchUsingAutoSuggest("mac");
        productObject = new ProductDetailsPage(driver);
        productObject.openEmailFriendPage();
        emailFriendObjects = new EmailFriendPage(driver);
        emailFriendObjects.emailFriend("moazadel116@yahoo.com","Go to email");
        Assert.assertEquals(emailFriendObjects.successMessage.getText(),"Your message has been sent.");
    }


}
