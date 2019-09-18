package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddReviewPage extends PageBase {
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitle;

    @FindBy(name = "AddProductReview.ReviewText")
    WebElement reviewText;

    @FindBy(css = "div.rating-options")
    WebElement ratingOption;

    @FindBy(id = "addproductrating_3")
    WebElement submitReviewBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    public void addReview(String rTitle, String rText) {
        setTextElementText(reviewTitle, rTitle);
        setTextElementText(reviewText, rText);
        clickBtn(ratingOption);
        clickBtn(submitReviewBtn);
    }
}
