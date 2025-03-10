package Pages;


import TestBase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends PageBase{

    @FindBy(id="emailAddress")
    public static WebElement enterEmail;


   @FindBy(id = "password")
    public static WebElement enterPassword;

   @FindBy(xpath="//label[contains(@for,'mantine-rzuffwesl')]//label[contains(@for,'mantine-rzuffwesl')]")
    public static WebElement rememberPassword;

   @FindBy(xpath= "//button[normalize-space()='Sign In']")
    public static WebElement SignInBtn;

    public loginpage(WebDriver driver1) {
        super(driver1);
    }

    public void enterEmail(){
     enterEmail.sendKeys();
   }
    public  void enterPassword(){
        enterPassword.sendKeys();
   }
    public  void rememberPassword(){
       rememberPassword.click();
   }
    public void SignInBtn(){
       SignInBtn.click();
   }

}
