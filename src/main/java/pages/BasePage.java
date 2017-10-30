package pages;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver= BaseSteps.getDriver();
    static String firstProduct="";

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void scrollAndWaitToBeClickable(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);

        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(By by){
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        }
    }
}
