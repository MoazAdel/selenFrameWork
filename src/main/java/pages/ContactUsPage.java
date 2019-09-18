package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement yourName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Enquiry")
    WebElement enquiry;

    @FindBy(css = "input.button-1.contact-us-button")
    WebElement submitBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    public void submitContactUs(String nameValue, String emailValue, String enquiryValue) {
        setTextElementText(yourName, nameValue);
        setTextElementText(email, emailValue);
        setTextElementText(enquiry, enquiryValue);
        clickBtn(submitBtn);
    }

}
