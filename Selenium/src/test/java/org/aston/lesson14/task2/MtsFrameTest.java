package org.aston.lesson14.task2;

import org.aston.lesson14.WebDriverInstance;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MtsFrameTest {
    static WebDriver driver;
    static TopUpOnlineFrame topUpOnlineFrame;
    final static Integer SUCCESSFUL_REQUEST = 200;
    final static By COOKIE_CANCEL_BUTTON_LOCATOR = By.xpath("//*[@class='btn btn_gray cookie__cancel']");

    @BeforeAll
    static void startSession() {
        driver = WebDriverInstance.getInstance();
        driver.get("https://www.mts.by/");
        driver.findElement(COOKIE_CANCEL_BUTTON_LOCATOR).click();
        topUpOnlineFrame = new TopUpOnlineFrame(driver);
    }

    @Test
    @DisplayName("Проверка отображения суммы")
    void checkSum() {
        Assertions.assertEquals(Double.valueOf(topUpOnlineFrame.getSentSum()), topUpOnlineFrame.getSumInFrameHeader());
        Assertions.assertEquals(Double.valueOf(topUpOnlineFrame.getSentSum()), topUpOnlineFrame.getSumInFrameButton());
    }

    @Test
    @DisplayName("Проверка номера телефона")
    void checkPhoneNumber() {
        Assertions.assertEquals(topUpOnlineFrame.getPhoneNumberSent(), topUpOnlineFrame.getPhoneNumberInFrame());
    }

    @Test
    @DisplayName("Проверка полей для ввода реквизитов карты")
    void checkCardInputFields() {
        List<String> expectedFields = new ArrayList<>
                (Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"));
        Assertions.assertEquals(expectedFields, topUpOnlineFrame.getActualFields());
    }

    @Test
    @DisplayName("Проверка иконок платежных систем")
    void checkIcons() {
        Assertions.assertTrue(topUpOnlineFrame.getIconsResponseCodes().stream()
                .allMatch(code -> code.equals(SUCCESSFUL_REQUEST)));
    }

    @AfterAll
    static void closeSession() {
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
