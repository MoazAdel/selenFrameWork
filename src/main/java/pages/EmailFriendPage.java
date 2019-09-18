package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendEmail;

    @FindBy(id = "PersonalMessage")
    WebElement personalMessage;

    @FindBy(css = "input.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;


    public void emailFriend(String FEmail,String PersonalMessage) {
        setTextElementText(friendEmail,FEmail);
        setTextElementText(personalMessage,PersonalMessage);
        clickBtn(sendEmailBtn);
    }
}
