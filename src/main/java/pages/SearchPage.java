package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class  SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchField;

    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(id = "ui-id-1")
    List<WebElement> productList;

    @FindBy(linkText ="Apple MacBook Pro 13-inch")
    WebElement productTitle;

    public void searchForItem(String productName) {
        setTextElementText(searchField, productName);
        clickBtn(searchBtn);
    }

    public void openProductDetailsPage() {
        clickBtn(productTitle);
    }

    public void productSearchUsingAutoSuggest(String searchTxt) {
        setTextElementText(searchField, searchTxt);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productList.get(0).click();
    }
}
