package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//div[@class='n-title__text']")
    WebElement titleItem;

    public boolean titleNameProduct(){
        String titleProduct=titleItem.getAttribute("value");
        if(titleProduct==firstProduct){
            return true;
        }else{return false;}
    }
}
