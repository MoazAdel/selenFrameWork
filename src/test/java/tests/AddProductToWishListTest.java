package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {

    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    WishListPage wishlistObj;
    String productName = "Apple MacBook Pro 13-inch";


    @Test(priority = 1)
    public void userCanAddProductToWishList() throws InterruptedException {
        searchObj = new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("mac");

        detailsObj = new ProductDetailsPage(driver);
        detailsObj.addProductToWishList();
        Thread.sleep(2000);
        detailsObj.wishListSwitchToPage.click();
                driver.navigate().to("https://demo.nopcommerce.com/wishlist");
        wishlistObj = new WishListPage(driver);
        Assert.assertTrue(wishlistObj.wishListHeader.isDisplayed());
        Assert.assertTrue(wishlistObj.productCell.getText().contains(productName));

    }

    @Test(priority = 2)
    public void userCanRemoveProduct() {
        wishlistObj = new WishListPage(driver);
        wishlistObj.removeProductFromCart();
    }

}
