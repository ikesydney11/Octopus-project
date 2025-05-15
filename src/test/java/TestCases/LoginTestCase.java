package TestCases;

import TestBase.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;
import Pages.loginpage;


public class LoginTestCase extends BaseTest {
   ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Report/reports.html");

    @Test(priority = 1)
public  void loginTestcase(){
         extent.createTest("Verify that user can successfully navigate to URL");
         extent.attachReporter(spark);
         loginpage page = new loginpage(driver);
         navigateToUrl("http://octopus.accionmfb.com:3000/dashboard/customers/1004472");
         loginpage.enterEmail.sendKeys("");
         loginpage.enterPassword.sendKeys("");
         loginpage.SignInBtn.click();
    }
   @Test(priority = 2)
    public void loginTest3() throws InterruptedException {
          extent.createTest("Verify that user cannot successfully log in with a valid password and invalid username");
          extent.attachReporter(spark);
          loginpage page = new loginpage(driver);
          loginpage.enterEmail.sendKeys("ikesydney11@gmail.com");
          loginpage.enterPassword.sendKeys("Chukwu41900@");
          page.SignInBtn();
          loginpage.enterEmail.clear();
          loginpage.enterPassword.clear();
    }
    @Test(priority = 3)
    public void loginTest4() throws InterruptedException {
          extent.createTest("Verify that user can log in with valid username and password");
          extent.attachReporter();
          loginpage page = new loginpage(driver);
          loginpage.enterEmail.sendKeys("iaghanchi@accionmfb.com");
          loginpage.enterPassword.sendKeys("Chukwu41900@");
          page.SignInBtn();

        System.out.println("Hello world + Emmaunal");
    }
    }









