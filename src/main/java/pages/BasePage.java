package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Stash;

/**
 * Created by aasx .
 */
public class BasePage {

   WebDriver driver;

   public BasePage() {
      driver = Stash.getDriver();
      PageFactory.initElements(driver, this);
   }

   public void waiting(WebElement webElement){
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.visibilityOf(webElement));
   }

}
