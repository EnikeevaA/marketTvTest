package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MarketPage extends BasePage {
    public MarketPage(){
        PageFactory.initElements(driver, this);
    }

    String[] xp2 = new String[3];
    private ArrayList<String> xpathGeneralSeletion = new ArrayList<>();
    private ArrayList<String> xpathElectricSection = new ArrayList<>();

    private static final String GENERAL_SECTION = "//ul[@class='topmenu__list']";
    private static final String GENERAL_SECTION_ALTERNATIVE = "//div[@class='n-topmenu-new-horizontal__links']/descendant::a[text()='%s']";
    private static final String GENERAL_SECTION_ALTERNATIVE2 = "//div[@class='n-navigation-vertical i-bem n-navigation-vertical_js_inited']/descendant::span[text()='%s']";

    private static final String ELECTRIC_SELECTION = "//ul[@class='topmenu__list']/descendant::a[text()='%s']";
    private static final String ELECTRIC_SELECTION_ALTERNATIVE = "//div[@class='n-topmenu-new-horizontal__links']/descendant::a[text()='%s']";
    private static final String ELECTRIC_SELECTION_ALTERNATIVE2 = "//div[@class='n-navigation-vertical-menu__column-container']/descendant::a[text()='%s']";

    public void chooseSection(String sectionName) {
        xpathGeneralSeletion.add(GENERAL_SECTION);
        xpathGeneralSeletion.add(GENERAL_SECTION_ALTERNATIVE);
        xpathGeneralSeletion.add(GENERAL_SECTION_ALTERNATIVE2);

        xp2[0] = GENERAL_SECTION;
        xp2[1] = GENERAL_SECTION_ALTERNATIVE;
        xp2[2] = GENERAL_SECTION_ALTERNATIVE2;

        WebElement element = getExistGeneralElement(xp2, sectionName);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void chooseElectronicSections(String electronicSectionName) {
        xpathElectricSection.add(ELECTRIC_SELECTION);
        xpathElectricSection.add(ELECTRIC_SELECTION_ALTERNATIVE);
        xpathElectricSection.add(ELECTRIC_SELECTION_ALTERNATIVE2);
        WebElement element = getExistElectricalElement(xpathElectricSection, electronicSectionName);
        element.click();
    }
    private WebElement getExistElectricalElement(ArrayList<String> xpath, String selectName) {
        for (String i : xpath) {
            try {
                return driver.findElement(By.xpath(String.format(i, selectName)));
            } catch (NoSuchElementException e) {
                System.out.println("Элемент с xpath-ом: " + i + " и параметром: " + selectName + " не найден");
            }
        }
        return null;
    }
    private WebElement getExistGeneralElement(String[] xpath,String selectName){
        for (int i=0;i<xpath.length;i++){
            try {
                if(i==xpath.length-1){
                    WebElement element=driver.findElement(By.xpath(".//*[text()='Все категории']"));
                    String script = "var object = arguments[0];"
                            + "var theEvent = document.createEvent(\"MouseEvent\");"
                            + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                            + "object.dispatchEvent(theEvent);";
                    ((JavascriptExecutor)driver).executeScript(script,element);
                }
                return driver.findElement(By.xpath(String.format(xpath[i],selectName)));
            }catch (NoSuchElementException e){
                System.out.println("Элемент с xpath"+i+"и параметром "+selectName+"не найден");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @FindBy(xpath = ".//div[@class='n-navigation-vertical-category']//span[contains(text(),'Электроника')]")
    WebElement electronicsItem;



}
