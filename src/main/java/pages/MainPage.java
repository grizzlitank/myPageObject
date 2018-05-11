package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = ".//a[text()='Маркет']")
    public WebElement market;

    public MarketPage getMarket(){
        market.click();
        return new MarketPage();
    }
}
