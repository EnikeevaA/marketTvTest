import org.junit.Test;
import steps.*;

public class MarketTest extends BaseSteps {

    @Test
    public void Test(){
        YandexSteps yandexSteps=new YandexSteps();
        MarketSteps marketSteps=new MarketSteps();
        TvSteps tvSteps=new TvSteps();
        ProductSteps productSteps=new ProductSteps();

        yandexSteps.stepGoToMarket();
        marketSteps.stepSelectAllCategoriesItem("Все категории");
        marketSteps.stepSelectElectronicsItem("Электроника");
        tvSteps.stepGoToTvMarket();
        tvSteps.stepFillPrice("20000");
        tvSteps.stepLgProducts();
        tvSteps.stepSamsProducts();
        tvSteps.firstNameProduct();
        tvSteps.checkListProducts();
        tvSteps.stepGoToProduct();
        productSteps.stepTitleName();
    }
}
