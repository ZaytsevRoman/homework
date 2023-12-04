package org.aston.lesson14.task2;

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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MtsFrameTest {
    static WebDriver driver;
    final static String SUM = "1.3";
    final static String PHONE_NUMBER = "297777777";
    final static Integer SUCCESSFUL_REQUEST = 200;
    final static int TIME_OUT = 3000;

    @BeforeAll
    static void startSession() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        openFrame();
    }

    static void openFrame() {
        WebElement phoneInputField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneInputField.sendKeys(PHONE_NUMBER);
        WebElement sumInputField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumInputField.sendKeys(SUM);
        WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        emailInputField.sendKeys("test@test.com");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//div/iframe")));
    }

    @Test
    @DisplayName("Проверка отображения суммы")
    void checkSum() {
        String textInHeader = driver.findElement(By.xpath("//app-header/header/div/div/p[1]")).getAttribute("innerText");
        String[] textInHeaderArray = textInHeader.split(" ");
        Assertions.assertEquals(Double.valueOf(SUM), Double.valueOf(textInHeaderArray[0]));

        String textInButton = driver.findElement(By.xpath("//app-card-page/div/div[1]/button")).getAttribute("innerText");
        String[] textInButtonArray = textInButton.split(" ");
        Assertions.assertEquals(Double.valueOf(SUM), Double.valueOf(textInButtonArray[1]));
    }

    @Test
    @DisplayName("Проверка номера телефона")
    void checkPhoneNumber() {
        String text = driver.findElement(By.xpath("//app-header/header/div/div/p[2]")).getAttribute("innerText");
        Assertions.assertEquals(PHONE_NUMBER, text.substring(text.length() - PHONE_NUMBER.length()));
    }

    @Test
    @DisplayName("Проверка полей для ввода реквизитов карты")
    void checkCardInputFields() {
        List<String> actualFields = driver.findElements(By.xpath("//app-input/div/div/div[1]/label")).stream()
                .map(e -> e.getAttribute("innerText"))
                .collect(Collectors.toList());
        List<String> expectedFields = new ArrayList<>(Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"));
        Assertions.assertEquals(expectedFields, actualFields);
    }

    @Test
    @DisplayName("Проверка иконок платежных систем")
    void checkIcons() {
        List<String> iconsUrls = driver.findElements(By.xpath("//app-input/div/div/div[2]/div/div//img")).stream()
                .map(e -> e.getAttribute("src"))
                .collect(Collectors.toList());
        List<Integer> iconsResponseCodes = new ArrayList<>();
        for (String iconUrl : iconsUrls) {
            try {
                URL url = new URL(iconUrl);
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
                httpURLConnect.setConnectTimeout(TIME_OUT);
                httpURLConnect.connect();
                iconsResponseCodes.add(httpURLConnect.getResponseCode());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Assertions.assertTrue(iconsResponseCodes.stream().allMatch(code-> code.equals(SUCCESSFUL_REQUEST)));
    }

    @AfterAll
    static void closeSession() {
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
