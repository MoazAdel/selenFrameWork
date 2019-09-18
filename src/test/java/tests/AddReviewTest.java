package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.sql.Time;

public class AddReviewTest extends TestBase {

    HomePage homeObjects;
    UserLoginPage loginObjects;
    SearchPage searchObjects;
    ProductDetailsPage detailsObjects;
    AddReviewPage reviewObjects;
    @Test
    public void userCanAddReview() {
        homeObjects = new HomePage(driver);
        homeObjects.userLogin();
        loginObjects = new UserLoginPage(driver);
        loginObjects.userLogin("moazadel3@gmail.com","101010");
        searchObjects = new SearchPage(driver);
        searchObjects.productSearchUsingAutoSuggest("mac");

        detailsObjects = new ProductDetailsPage(driver);
        detailsObjects.addReviewBtn.click();
        reviewObjects = new AddReviewPage(driver);
        reviewObjects.addReview("About the item","Good one");

//        Assert.assertTrue(reviewObjects.successMessage.getText().contains("Product review is successfully added."));
        System.out.println("Donnnnnnne");
    }

}
