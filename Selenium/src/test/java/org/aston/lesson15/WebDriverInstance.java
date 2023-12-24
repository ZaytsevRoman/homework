package org.aston.lesson15;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverInstance {
    private static WebDriver instance;

    private WebDriverInstance() {
    }

    private static WebDriver initialize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(960,900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            return instance = initialize();
        }
        return instance;
    }
}
