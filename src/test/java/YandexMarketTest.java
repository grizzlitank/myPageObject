import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ElectronicsPage;
import pages.MainPage;
import pages.ProductPage;
import utils.Stash;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class YandexMarketTest {
    WebDriver driver;

    @Parameterized.Parameter(0)
    public String itemName;

    @Parameterized.Parameter(1)
    public int itemPrice;

    @Parameterized.Parameter(2)
    public List<String> productionNames;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"Телевизоры", 20000, Arrays.asList("LG", "Samsung")}, {"Наушники", 5000, Arrays.asList("Sennheiser")}});
    }


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Stash.put("driver", driver);
        driver.get("https://yandex.ru/");
    }

    @Test
    public void search_and_check(){

        new MainPage()
                .getMarket()
                .getElectronics()
                .getProduct(itemName)
                .getFilter()
                .getSearchByFilter(itemPrice, productionNames)
                .getTwelve()
                .check_and_save_and_search()
                .check();
    }

    @After
    public void shutDown(){
        Stash.getDriver().quit();
    }
}
