package TestBase;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.ExtentManager;

import java.time.Duration;

import static utils.ExtentManager.extent;


public class BaseTest {
    protected static WebDriver driver;
    //ExtentManager manager = new ExtentManager();

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
    }
    public static void navigateToUrl(String Url) {
        driver.get(Url);
    }
    public void sleep(int sec) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void validateText(WebElement element, String message) {
        Assert.assertEquals(element.getText(), message, "Expected " + message + " but found " + element.getText());
    }
    ExtentReports reports = new ExtentReports(){
    };

   // @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    @AfterSuite
    public void tearDownExtentReport(){
        if (extent != null){
            extent.flush();
        }
    }
}

