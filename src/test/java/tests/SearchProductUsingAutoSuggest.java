package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test
    public void userCanSearchByAutoSuggest() {
        try {
            searchObject = new SearchPage(driver);
            searchObject.productSearchUsingAutoSuggest("mac");
            detailsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
        }catch (Exception e) {
            System.out.println("Error Occurred" + e.getMessage());
        }
    }
}
