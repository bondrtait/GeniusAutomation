package common;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServiceSingleton {
    private static AppiumDriverLocalService appiumServiceInstance;

    private AppiumServiceSingleton() {
    }

    public static AppiumDriverLocalService getInstance() {
        if (appiumServiceInstance == null) {
            appiumServiceInstance = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "warn"));
        }

        return appiumServiceInstance;
    }
}
