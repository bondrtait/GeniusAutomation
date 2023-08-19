package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.time.Duration;
import java.util.Properties;

public class DriverSingleton {
    private static AndroidDriver driver;

    private DriverSingleton() {
    }

    public static AndroidDriver getInstance() {
        if (driver == null) {
            Properties props = PropertiesReader.getProp(".\\src\\main\\resources\\config.properties");
            UiAutomator2Options options = new UiAutomator2Options();
            options.setUdid(props.getProperty("deviceUdid"));
            options.setApp(props.getProperty("apkLocation"));
            options.setAppWaitActivity("flow.onboarding.OnboardingActivity");

            driver = new AndroidDriver(AppiumServiceSingleton.getInstance().getUrl(), options);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(Long.parseLong(props.getProperty("implicitWait"))));
        }

        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
