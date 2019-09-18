package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCartTest extends TestBase {
    HomePage homeObjects;
    SearchPage searchObjects;
    ProductDetailsPage detailsObjects;
    AddToCartPage cartPage;
    String productname = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanSearchForProduct() {
        searchObjects = new SearchPage(driver);
        searchObjects.productSearchUsingAutoSuggest("mac");
        detailsObjects = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObjects.productNameBreadCrumb.getText().contains(productname));

    }

    @Test(priority = 2)
    public void UserAddProductToCart() throws InterruptedException {
        detailsObjects = new ProductDetailsPage(driver);
        detailsObjects.addToCart();
        Thread.sleep(1000);
        driver.navigate().to("http://demo.nopcommerce.com/cart");
    }

    @Test(priority = 4)
    public void UserCanRemoveProduct() {
        cartPage = new AddToCartPage(driver);
        cartPage.removeProductFromCart();
    }

    @Test(priority = 3)
    public void UserCanUpdateProduct() {
        cartPage = new AddToCartPage(driver);
        cartPage.UpdateProductQuantity("4");
    }
}
