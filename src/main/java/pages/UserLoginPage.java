package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
    public UserLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Password")
    WebElement passTxt;

    @FindBy(css = "input.button-1.login-button")
    WebElement loginBtn;

    public void userLogin(String email, String password) {
        setTextElementText(emailTxt, email);
        setTextElementText(passTxt, password);
        clickBtn(loginBtn);
    }
}
