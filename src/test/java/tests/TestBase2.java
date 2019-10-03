package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase2 {

    public static String BaseURL = "http://demo.nopcommerce.com";

    protected ThreadLocal<RemoteWebDriver> driver =null;

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) throws MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browserName);
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
        getDriver().navigate().to(BaseURL);

    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void stropDriver() {
        getDriver().quit();
        driver.remove();
    }

    //Take Screenshots when test cases failed and add it in the Screenshot Folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed\n");
            System.out.println("Taking ScreenShot...");
            Helper.captureScreenshot(getDriver(), result.getName());
        }
    }
}
