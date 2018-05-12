package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Stash;

import java.util.List;

public class SearchResultPage extends BasePage {



    @FindBy(xpath = ".//div[@class='n-snippet-card2__title']")
    List<WebElement> results1;

    @FindBy(xpath = ".//div[@class='n-snippet-cell2__title']")
    List<WebElement> results2;

    @FindBy(xpath = ".//input[@id='header-search']")
    public WebElement search;

    @FindBy(xpath = ".//span[@class='search2__button']/button")
    public WebElement searchButton;

    public TitlePage check_and_save_and_search(){
        String title = "";

        if(Stash.exist()) {

            Assert.assertEquals("Количество записей соответствует 12", 12, results2.size());
            title = results2.get(0).findElement(By.xpath(".//a")).getText();
        } else {

            Assert.assertEquals("Количество записей соответствует 12", 12, results1.size());
            title = results1.get(0).findElement(By.xpath(".//a")).getText();
        }
        Stash.put("Название", title);
        search.sendKeys(title);
        searchButton.click();
        return new TitlePage();
    }
}
