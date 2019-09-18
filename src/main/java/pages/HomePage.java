package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
     public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;
     public void openRegistrationPage() {
        clickBtn(registerLink);
     }

    @FindBy(linkText = "Log in")
    WebElement logInBtn;

    public void userLogin() {
        clickBtn(logInBtn);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUs;

    public void openContactUsPage() {
        scrollToButtom();
        clickBtn(contactUs);
    }

    @FindBy(id = "customerCurrency")
    WebElement currencyDDL;

    public void changeCurrency() {
        select = new Select(currencyDDL);
        select.selectByVisibleText("Euro");
    }

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computerMenu;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a ")
    WebElement notebooksMenu;

    public void selectNoteBooksMenu() {
        action.moveToElement(computerMenu)
                .moveToElement(notebooksMenu)
                .click()
                .build()
                .perform();
    }

}
