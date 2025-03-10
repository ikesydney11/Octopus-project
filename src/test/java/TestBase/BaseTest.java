package TestBase;

import Pages.loginpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
     public static WebDriver driver;
     public static ExtentReports extent;
     public ExtentSparkReporter sparkReport;
   @BeforeClass
    public static void  setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();


    }
    public static void  navigateToUrl(String Url){
        driver.get(Url);

    }
     public void sleep(int sec){
        try{
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

     }
     public void validateText(WebElement element, String message) {
        Assert.assertEquals(element.getText(), message, "Expected " + message + " but found " + element.getText());
    }
     public void reporterSetup() {
        extent = new ExtentReports();
        sparkReport = new ExtentSparkReporter("Reports/test_report.html");
        extent.attachReporter(sparkReport);
        sparkReport.config().setReportName("Test framework report");
        sparkReport.config().setTheme(Theme.DARK);
        extent.setSystemInfo("Author", "Ikechukwu");
        extent.setSystemInfo("environment", "Staging");
    }

    @AfterClass
    public void tearDown()
     {if(driver!= null) driver.quit();
     }
    public static void FlushReport(){
       extent.flush();

    }
     }

