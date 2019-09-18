package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;

    @FindBy(id = "FirstName")
    WebElement fnTxtBox;

    @FindBy(id = "LastName")
    WebElement lnTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(linkText = "Log out")
    WebElement logOutBtn;

    @FindBy(linkText = "My account")
    public WebElement myAccountLink;

    public void userRegistration(String FN,String LN, String email, String password) {
        clickBtn(genderRdoBtn);
        setTextElementText(fnTxtBox, FN);
        setTextElementText(lnTxtBox, LN);
        setTextElementText(emailTxtBox, email);
        setTextElementText(passwordTxtBox,password);
        setTextElementText(confirmPasswordTxtBox,password);
        clickBtn(registerBtn);
    }

    public void userLogOut() {
        clickBtn(logOutBtn);
    }

    public void openMyAccountPage() {
        clickBtn(myAccountLink);
    }



}
