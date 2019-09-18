package tests;

import org.testng.annotations.Test;
import pages.*;

public class CheckOutTest extends TestBase {

    HomePage homeObj;
    UserLoginPage loginObj;
    SearchPage searchObj;
    ProductDetailsPage detailsObj;
    CheckOutPage checkoutObj;
    AddToCartPage cartPage;

    @Test(priority = 1)
    public void userLogin() throws InterruptedException {
        homeObj = new HomePage(driver);
        homeObj.userLogin();
        loginObj = new UserLoginPage(driver);
        loginObj.userLogin("moazadel3@gmail.com","101010");
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void userSearch() {
        searchObj = new SearchPage(driver);
        searchObj.productSearchUsingAutoSuggest("mac");
    }
    @Test(priority = 3)
    public void userAddProductToCart() throws InterruptedException {
        detailsObj = new ProductDetailsPage(driver);
        detailsObj.addToCart();
        Thread.sleep(1000);
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        Thread.sleep(2000);

    }
    @Test(priority = 4)
    public void userCheckOut() throws InterruptedException {
        cartPage = new AddToCartPage(driver);
        cartPage.checkout();
        Thread.sleep(1000);
        checkoutObj = new CheckOutPage(driver);
        checkoutObj.checkOut("moaz","Adel","moazadel111@asd.com","Test1","Cairo","TestAdd","10101","20551581","51836186");

    }
}
