package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.AbstractMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(String browserName) {

        if(browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }   else if (browserName.equalsIgnoreCase("firefox")) {
           driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if(browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

        }
//        driver = new FirefoxDriver();

        //Headless Browser Testing

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }

    //Take Screenshots when test cases failed and add it in the Screenshot Folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed\n");
            System.out.println("Taking ScreenShot...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

}
