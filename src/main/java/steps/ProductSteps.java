package steps;

import pages.ProductPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ProductSteps {
    ProductPage productPage=new ProductPage();

    @Step("Сравнение название товара с сохраненным названием")
    public void stepTitleName(){
        productPage.titleNameProduct();
    }
}
