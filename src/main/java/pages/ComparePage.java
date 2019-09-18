package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ComparePage extends PageBase {
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.clear-list")
    public WebElement clearListBtn;

    @FindBy(css = "table.compare-products-table")
    public WebElement productsTable;

    @FindBy(css = "div.no-data")
    public WebElement noData;

    @FindBy(tagName = "tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "td")
    public List<WebElement> allCols;


    public void clearCompareList() {
        clickBtn(clearListBtn);
    }

    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement firstProduct;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement secondProduct;


    public void compareProducts() {
        //Get All Rows
        System.out.println(allRows.size());


        for (WebElement col : allCols) {
            System.out.println(col.getText() + "\t");
        }

    }
}
