package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
    HomePage homeObjects;
    ProductDetailsPage detailsObject;
   SearchPage searchObject;

    @Test
    public void userCanChangeCurrency() {
        homeObjects = new HomePage(driver);
        homeObjects.changeCurrency();
    }

    @Test
    public void userCanSearchByAutoSuggest() {
        try {
            searchObject = new SearchPage(driver);
            searchObject.productSearchUsingAutoSuggest("mac");
            detailsObject = new ProductDetailsPage(driver);
            Assert.assertTrue(detailsObject.productPriceLable.getText().contains("Ђ"));
            System.out.println(detailsObject.productPriceLable.getText());
        }catch (Exception e) {
            System.out.println("Error Occurred" + e.getMessage());
        }
    }
}
