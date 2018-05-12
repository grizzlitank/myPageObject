package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Stash;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {



    @FindBy(xpath = ".//span[contains(text(),'Показывать по 12')]")
    public WebElement showTwelve;

    @FindBy(xpath = ".//button[@role='listbox']")
    public WebElement show48;




    public SearchResultPage getTwelve(){
        show48.click();
        waiting(showTwelve);
        showTwelve.click();
        WebDriverWait wait = new WebDriverWait(driver,60);
        if(Stash.exist()) {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(".//div[@class='n-snippet-cell2__title']"), 12));
        }else{
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(".//div[@class='n-snippet-card2__title']"), 12));
        }


        return new SearchResultPage();
    }




}
