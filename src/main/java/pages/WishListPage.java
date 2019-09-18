package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td.product")
    public WebElement productCell;

    @FindBy(css = "h1")
    public WebElement wishListHeader;

    @FindBy(name = "updatecart")
    public WebElement updateWishListBtn;

    @FindBy(className = "remove-from-cart")
    public WebElement removeFromCartCheck;

    @FindBy(css = "div.no-data")
    public WebElement emptyCartLabel;

    public void removeProductFromCart() {
        clickBtn(removeFromCartCheck);
        clickBtn(updateWishListBtn);
    }
}
