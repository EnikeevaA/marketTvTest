package steps;

import org.openqa.selenium.By;
import pages.YandexPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexSteps {
    YandexPage yandexPage=new YandexPage();

    @Step("Выполнен переход в Яндекс Маркет {0}")
    public void stepGoToMarket(){
        yandexPage.goToMarket.click();
    }
}
