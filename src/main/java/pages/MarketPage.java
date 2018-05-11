package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPage extends BasePage {

    @FindBy(xpath = ".//a[text()='Электроника']")
    public WebElement elecronics;

    public ElectronicsPage getElectronics(){
        elecronics.click();
        return new ElectronicsPage();
    }

}
