package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddCompareTest extends TestBase {

    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop";

    // 1- search for product #1
    // 2- search for product #2
    // 3- add to compare
    // 4- clear list

    ProductDetailsPage detailsObject;
    ComparePage compareObject;
    SearchPage searchObject;

    @Test(priority = 1)
    public void userCanCompareTwoProducts () throws InterruptedException {
       detailsObject = new ProductDetailsPage(driver);
       compareObject = new ComparePage(driver);
       searchObject = new SearchPage(driver);

       searchObject.productSearchUsingAutoSuggest(firstProductName);
       detailsObject.addProductToCompare();
       Thread.sleep(1000);
       driver.navigate().back();
       searchObject.productSearchUsingAutoSuggest(secondProductName);
       detailsObject.addProductToCompare();
       Thread.sleep(1000);
       driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
       Assert.assertTrue(compareObject.firstProduct.isDisplayed());
       Assert.assertTrue(compareObject.secondProduct.isDisplayed());
       compareObject.compareProducts();

    }

    @Test(priority = 2)
    public void userCanClearCompareList() {
        compareObject.clearCompareList();
    }


}
