package TestCases;

import TestBase.BaseTest;
import org.testng.annotations.Test;
import Pages.loginpage;


public class logintestcase extends BaseTest {
    @Override
    public void reporterSetup() {
        super.reporterSetup();
    }

    @Test(priority = 1) // Verify that user can successfully navigate to URL
public  void loginTestcase(){
        loginpage page = new loginpage(driver);
         navigateToUrl("http://octopus.accionmfb.com:3000/dashboard/customers/1004472");
         loginpage.enterEmail.sendKeys("");
         page.enterPassword.sendKeys("");
         page.SignInBtn.click();

    }
    @Test(priority = 2)// Verify that user cannot log in with a valid username and invalid password
    public void loginTest2(){
        loginpage page = new loginpage(driver);
        page.enterEmail.sendKeys("iaghanchi@accionmfb.com");
        page.enterPassword.sendKeys("");
        page.SignInBtn.click();
    }
    @Test(priority = 3) //Verify that user cannot successfully log in with a valid password and invalid username
    public void loginTest3() throws InterruptedException {
          loginpage page = new loginpage(driver);
          page.enterEmail.sendKeys("ikesydney11@gmail.com");
          page.enterPassword.sendKeys("Chukwu41900@");
          page.SignInBtn();
          page.enterEmail.clear();
          page.enterPassword.clear();
    }
    @Test(priority = 4) //Verify that user can log in with valid username and password
    public void loginTest4() throws InterruptedException {
          loginpage page = new loginpage(driver);
          page.enterEmail.sendKeys("iaghanchi@accionmfb.com");
          page.enterPassword.sendKeys("Chukwu41900@");
          page.SignInBtn();
    }
    }









