package org.aston;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriverInstance {
    private static AndroidDriver instance;

    private AndroidDriverInstance() {
    }

    private static AndroidDriver initialize() {
        AndroidDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Medium Phone API 30");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public static AndroidDriver getInstance() {
        if (instance == null) {
            return instance = initialize();
        }
        return instance;
    }
}
