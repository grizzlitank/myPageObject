package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Stash;

import java.util.List;

public class SearchResultPage extends BasePage {



    @FindBy(xpath = ".//div[@class='n-snippet-card2__title']")
    List<WebElement> results;

    @FindBy(xpath = ".//input[@id='header-search']")
    public WebElement search;

    @FindBy(xpath = ".//span[@class='search2__button']/button")
    public WebElement searchButton;

    public TitlePage check_and_save_and_search(){
        Assert.assertEquals("Количество записей соответствует 12", 48, results.size());
        String title = results.get(0).findElement(By.xpath(".//a")).getText();
        Stash.put("Название", title);
        search.sendKeys(title);
        searchButton.click();
        return new TitlePage();
    }
}
