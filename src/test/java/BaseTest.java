import common.AppiumServiceSingleton;
import common.DriverSingleton;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    protected AppiumDriverLocalService service;
    protected AndroidDriver driver;
//    protected FormPage formPage;

    @BeforeMethod
    public void setUp(){

        //start Appium server
        AppiumServiceSingleton.getInstance().start();

        driver = DriverSingleton.getInstance();

//        formPage = new FormPage(driver);
    }

    @Test
    public void testOne() throws InterruptedException {
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quit();
        AppiumServiceSingleton.getInstance().stop();
    }


}
