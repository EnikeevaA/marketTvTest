package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {
    MarketPage marketPage=new MarketPage();

    @Step("Выбраны  {0}")
    public void stepSelectAllCategoriesItem(String item){
        marketPage.chooseSection(item);
    }

    @Step("выбрана категория {0}")
    public void stepSelectElectronicsItem(String item){
        marketPage.chooseElectronicSections(item);
    }


}
