package utils;

import org.openqa.selenium.OutputType;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseSteps;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import org.openqa.selenium.TakesScreenshot;

public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
