package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase extends BaseTest  {

   public WebDriver driver;
   public PageBase(WebDriver ldriver){
       super();
       driver = ldriver;
       PageFactory.initElements(driver, this);
   }
   public void WaitForElement(WebElement element){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
       wait.until(ExpectedConditions.visibilityOfAllElements(element));
   }
  public void click(WebElement element){
       WaitForElement(element);
       element.click();
  }
  public void enterText(WebElement element, String message){

       WaitForElement(element);
       element.sendKeys();
  }
}
