package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPage extends BasePage {
    @FindBy(xpath = ".//A[contains(text(),'Маркет')]")
    public WebElement goToMarket;

    public YandexPage(){
        PageFactory.initElements(driver,this);
    }

}
