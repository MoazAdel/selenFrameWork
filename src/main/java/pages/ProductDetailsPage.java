package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
    public WebElement productNameBreadCrumb;

    @FindBy(css = "input.button-2.email-a-friend-button")
    public WebElement emailAFriendBtn;

    public void openEmailFriendPage() {
        clickBtn(emailAFriendBtn);
    }

    @FindBy(css = "span.price-value-4")
    public WebElement productPriceLable;

    @FindBy(linkText = "Add your review")
    public WebElement addReviewBtn;

    @FindBy(css = "input.button-2.add-to-wishlist-button")
    WebElement addToWishListBtn;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
    public WebElement wishListSwitchToPage;

    public void addProductToWishList() {
        clickBtn(addToWishListBtn);
//        clickBtn(wishListSwitchToPage);
    }

    @FindBy(css = "input.button-2.add-to-compare-list-button")
    WebElement compareButton;

    public void addProductToCompare() {
        clickBtn(compareButton);
    }

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;

    public void addToCart() {
        clickBtn(addToCartBtn);
    }



}
