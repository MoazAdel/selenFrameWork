package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageBase {
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"removefromcart17337\"]")
    WebElement removeFromCart;

    @FindBy(name = "updatecart")
    WebElement updateCart;

    @FindBy(css = "input.qty-input")
    WebElement itemQuantity;

    @FindBy(css = "span.product-subtotal")
    WebElement productSubTotal;

    @FindBy(css = "span.product-unit-price")
    WebElement productUnitPrice;

    public void removeProductFromCart() {
        clickBtn(removeFromCart);
        clickBtn(updateCart);
    }

    public void UpdateProductQuantity(String quantity) {
        clearText(itemQuantity);
        setTextElementText(itemQuantity, quantity);
        clickBtn(updateCart);
    }

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(id = "termsofservice")
    WebElement iAgree;

    public void checkout() {
        clickBtn(iAgree);
        clickBtn(checkOutBtn);
    }
}
