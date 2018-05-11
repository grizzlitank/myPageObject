package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return new SearchResultPage();
    }




}
