package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Stash;

public class TitlePage extends BasePage {

    @FindBy(xpath = ".//h1")
    public WebElement title;

    public void check(){
        Assert.assertEquals("Название соответствует первому названию из списка", Stash.get("Название"), title.getText());
    }
}
