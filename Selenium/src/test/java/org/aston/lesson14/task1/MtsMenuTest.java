package org.aston.lesson14.task1;

import org.aston.lesson14.WebDriverInstance;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MtsMenuTest {
    static WebDriver driver;
    static InputFields inputFields;
    final static By COOKIE_CANCEL_BUTTON_LOCATOR = By.xpath("//*[@class='btn btn_gray cookie__cancel']");

    @BeforeAll
    static void startSession() {
        driver = WebDriverInstance.getInstance();
        driver.get("https://www.mts.by/");
        driver.findElement(COOKIE_CANCEL_BUTTON_LOCATOR).click();
        inputFields = new InputFields(driver);
    }

    @Test
    @DisplayName("Проверка полей \"Услуги связи\"")
    void checkFieldsCommunicationServices() {
        Assertions.assertEquals("Номер телефона", inputFields.getPhoneNumberField());
        checkSumAndEmail();
    }

    @Test
    @DisplayName("Проверка полей \"Домашний интернет\"")
    void checkFieldsHomeInternet() {
        Assertions.assertEquals("Номер абонента", inputFields.getSubscriberNumber());
        checkSumAndEmail();
    }

    @Test
    @DisplayName("Проверка полей \"Рассрочка\"")
    void checkFieldsInstallment() {
        Assertions.assertEquals("Номер счета на 44", inputFields.getAccountNumberBy44());
        checkSumAndEmail();
    }

    @Test
    @DisplayName("Проверка полей \"Задолженность\"")
    void checkFieldsDebt() {
        Assertions.assertEquals("Номер счета на 2073", inputFields.getAccountNumberBy2073());
        checkSumAndEmail();
    }

    void checkSumAndEmail() {
        Assertions.assertEquals("Сумма", inputFields.getSumField());
        Assertions.assertEquals("E-mail для отправки чека", inputFields.getEmailField());
    }

    @AfterAll
    static void closeSession() {
        driver.quit();
    }
}
