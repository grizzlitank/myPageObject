package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import utils.Stash;

import java.util.Formatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElectronicsPage extends BasePage{

    private static final String productXpath = ".//div[@class='catalog-menu i-bem catalog-menu_js_inited']//a[contains(text(), '%s')][1]";



    public WebElement product;

    public ProductPage getProduct(String name) {
        Formatter f = new Formatter();

        if (name.equals("Наушники")){
            product = driver.findElement(By.xpath(".//a[contains(text(), 'Портативная техника')]/following-sibling::div/a[contains(text(), 'Наушники')]"));
            Stash.put("Наушники", name);
        } else{
            product = driver.findElement(By.xpath(f.format(productXpath, name).toString()));
        }
        product.click();
        return new ProductPage();
    }


}
