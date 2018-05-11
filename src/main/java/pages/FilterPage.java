package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilterPage extends BasePage{

    private static final String productionXpath = ".//label[text()='%s']";

    @FindBy(xpath = ".//*[@id='glf-priceto-var']")
    public WebElement priceLimit;


    List<WebElement> productions = new ArrayList<>();

    public WebElement prod1;

    public WebElement prod2;

    @FindBy(xpath = ".//span[text()='Показать подходящие']/parent::a")
    public WebElement filterButton;

    public SearchPage getSearchByFilter(int price, String prodName1){
        priceLimit.sendKeys(String.valueOf(price));
        Formatter f = new Formatter();
        prod1 = driver.findElement(By.xpath(f.format(productionXpath, prodName1).toString()));
        prod1.click();
        filterButton.click();
        return new SearchPage();

    }

    public SearchPage getSearchByFilter(int price, List<String> productionNames){
        priceLimit.sendKeys(String.valueOf(price));


        productionNames.forEach(a->
            productions.add(driver.findElement(By.xpath(new Formatter().format(productionXpath, a).toString())))
        );

        productions.forEach(a-> a.click());


        filterButton.click();
        return new SearchPage();

    }
}
