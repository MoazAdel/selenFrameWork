package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement billingFN;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement billingLN;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement billingEmail;

    @FindBy(id = "BillingNewAddress_Company")
    WebElement billingComp;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement billingCIE;

    public void selectCountry() throws InterruptedException {
        select = new Select(billingCIE);
        select.selectByVisibleText("Egypt");
        Thread.sleep(2000);
    }

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement billingStateID;

    public void selectState() {
        select = new Select(billingStateID);
        select.selectByVisibleText("Other (Non US)");
    }

    @FindBy(id = "BillingNewAddress_City")
    WebElement billingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement billingAdd1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement billingZC;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billingPN;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    WebElement billingFaxN;

    @FindBy(css = "input.button-1.new-address-next-step-button")
    WebElement continueBtn;

    @FindBy(css = "input.button-1.shipping-method-next-step-button")
    WebElement continueBtnShippingMethod;

    @FindBy(css = "input.button-1.payment-method-next-step-button")
    WebElement continueBtnPaymentMethod;

    @FindBy(css = "input.button-1.payment-method-next-step-button")
    WebElement continueBtnPaymentInfo;

    @FindBy(css = "input.button-1.confirm-order-next-step-button")
    WebElement continueBtnConfirmPayment;

    @FindBy(id = "shippingoption_1")
    WebElement secondOption;

    @FindBy(id = "paymentmethod_0")
    WebElement moneyCheck;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/form/div/div/div/div/table/tbody/tr/td/p[3]")
    WebElement successMessage;

    @FindBy(css = "div.shipping-info-wrap")
    WebElement shippingAddressAssert;

    public void checkOut(String FN,
                         String LN,
                         String email,
                         String company,
                         String city,
                         String address1,
                         String zCode,
                         String phone,
                         String faxNum) throws InterruptedException {
        clearText(billingFN);
        setTextElementText(billingFN,FN);
        clearText(billingLN);
        setTextElementText(billingLN, LN);
        setTextElementText(billingAdd1, address1);
        clearText(billingEmail);
        setTextElementText(billingEmail, email);
        setTextElementText(billingComp, company);
        selectCountry();
        selectState();
        setTextElementText(billingCity, city);
        setTextElementText(billingZC, zCode);
        setTextElementText(billingPN, phone);
        setTextElementText(billingFaxN, faxNum);
        setTextElementText(billingPN, phone);

        clickBtn(continueBtn);
        Thread.sleep(2000);

        clickBtn(secondOption);
        clickBtn(continueBtnShippingMethod);
        Thread.sleep(2000);

        clickBtn(moneyCheck);
        clickBtn(continueBtnPaymentMethod);
        Thread.sleep(2000);

        clickBtn(continueBtnPaymentInfo);
        Thread.sleep(2000);

        clickBtn(continueBtnConfirmPayment);
        Thread.sleep(2000);


    }




}
