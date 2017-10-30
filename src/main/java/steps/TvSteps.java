package steps;

import org.openqa.selenium.By;
import pages.TvPage;
import ru.yandex.qatools.allure.annotations.Step;
import static org.junit.Assert.assertEquals;

public class TvSteps {
    TvPage tvPage=new TvPage();

    @Step("произведен переход в категории Телевизоры")
    public void stepGoToTvMarket(){
        tvPage.goToTvMarket.click();
    }
    @Step("Задан параметр поиска от {0}")
    public void stepFillPrice(String value){
        tvPage.fillPrice(value);
    }

    @Step("выбрана продукция LG")
    public  void stepLgProducts(){
        tvPage.lgRadioBtn.click();
    }

    @Step("выбрана продукция Samsung")
    public  void stepSamsProducts(){
        tvPage.samsungRadioBtn.click();
    }

    @Step("первый продукт введен в поиск")
    public void firstNameProduct(){
        tvPage.firstProductForSearch(1);
    }
    @Step("Проверка количества продуктов на странице")
    public void checkListProducts(){
        assertEquals("Проверка списка на наличие 12 элементов",tvPage.products.size(),12);
    }

    @Step("произведен переход к первому продукту")
    public void stepGoToProduct(){
        tvPage.findProductBtn.click();
    }
}
