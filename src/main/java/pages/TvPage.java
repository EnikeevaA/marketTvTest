package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TvPage extends BasePage {

    @FindBy(xpath = "//div[@class='catalog-menu i-bem catalog-menu_js_inited']//*[contains(text(),'Телевизоры')]")
    public WebElement goToTvMarket;

    @FindBy(xpath = "//div[@class='n-filter-panel-aside__content']//*[@class='input__control']")
    WebElement price;

    @FindBy(xpath = "//div[@class='n-filter-block__list-items i-bem']//*[contains(text(),'LG')]")
    public WebElement lgRadioBtn;

    @FindBy(xpath = "//div[@class='n-filter-block__list-items i-bem']//*[contains(text(),'Samsung')]")
    public WebElement samsungRadioBtn;

    @FindBy(id = "header-search")
    WebElement searchInput;

    @FindBy(xpath = "//div[@class='n-snippet-card2__title']")
    public List<WebElement> products;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findProductBtn;

    public TvPage(){
        PageFactory.initElements(driver, this);
    }

    public void firstProductForSearch(int productIndex){
        firstProduct=products.get(productIndex).findElement(By.xpath("./a")).getText();
        fillField(searchInput,firstProduct);
    }
     public void fillPrice(String value){
         fillField(price, value);
     }

}
