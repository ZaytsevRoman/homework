package org.aston;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MtsTest {
    static WebDriver driver;
    final static Integer SUCCESSFUL_REQUEST = 200;
    final static int TIME_OUT = 3000;

    @BeforeAll
    static void startSession() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
    }

    @Test
    @DisplayName("Проверка названия блока")
    void checkBlockName() {
        WebElement replenishmentBlock = driver.findElement(By.xpath("//*[contains(text(),'Онлайн пополнение')]"));
        Assertions.assertEquals("Онлайн пополнение без комиссии", replenishmentBlock.getAccessibleName());
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем")
    void checkIcon() {
        List<WebElement> allIcons = driver.findElements(By.xpath("//*[@class=\"pay__partners\"]//img"));
        List<Integer> iconsResponseCodes = new ArrayList<>();
        for (WebElement icon : allIcons) {
            String iconUrl = icon.getAttribute("src");
            try {
            URL url = new URL(iconUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(TIME_OUT);
            httpURLConnect.connect();
            iconsResponseCodes.add(httpURLConnect.getResponseCode());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertTrue(iconsResponseCodes.stream().allMatch(code-> code.equals(SUCCESSFUL_REQUEST)));
        }
    }

    @Test
    @DisplayName("Проверка ссылки \"Подробнее о сервисе\"")
    void checkUrl() {
        WebElement moreAboutService = driver.findElement(By.xpath("//*[contains(text(),'Подробнее о сервисе')]"));
        String moreAboutServiceUrl = moreAboutService.getAttribute("href");
        Integer responseCode;
        try {
            URL url = new URL(moreAboutServiceUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(TIME_OUT);
            httpURLConnection.connect();
            responseCode = httpURLConnection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(SUCCESSFUL_REQUEST, responseCode);
    }

    @Test
    @DisplayName("Проверка кнопки \"Продолжить\"")
    void checkButton() {
        WebElement phoneInputField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumInputField.sendKeys("1");
        WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        emailInputField.sendKeys("test@test.com");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/iframe")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div/iframe")).isDisplayed());
    }

    @AfterAll
    static void closeSession() {
        driver.quit();
    }
}
