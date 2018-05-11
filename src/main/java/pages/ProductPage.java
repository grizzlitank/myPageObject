package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{


    @FindBy(xpath = ".//a[text()='Перейти ко всем фильтрам']")
    public WebElement filter;

    public FilterPage getFilter(){
        filter.click();
        return new FilterPage();
    }
}
