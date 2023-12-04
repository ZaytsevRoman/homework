package org.aston.lesson14.task1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MtsMenuTest {
    static WebDriver driver;
    static Actions builder;
    static InputFields inputFields;

    @BeforeAll
    static void startSession() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        builder = new Actions(driver);
        inputFields = new InputFields(driver);
    }

    @Test
    @DisplayName("Проверка полей \"Услуги связи\"")
    void checkFieldsCommunicationServices() {
        inputFields.checkPhoneNumberField();
        checkSumAndEmail();
    }

    @Test
    @DisplayName("Проверка полей \"Домашний интернет\"")
    void checkFieldsHomeInternet() {
        menuClick("//*[@id=\"pay-section\"]//li[2]/p");
        inputFields.checkSubscriberNumber();
        checkSumAndEmail();
    }

    @Test
    @DisplayName("Проверка полей \"Рассрочка\"")
    void checkFieldsInstallment() {
        menuClick("//*[@id=\"pay-section\"]//li[3]/p");
        inputFields.checkAccountNumberBy44();
        checkSumAndEmail();
    }

    @Test
    @DisplayName("Проверка полей \"Задолженность\"")
    void checkFieldsDebt() {
        menuClick("//*[@id=\"pay-section\"]//li[4]/p");
        inputFields.checkAccountNumberBy2073();
        checkSumAndEmail();
    }

    void menuClick(String xpath) {
        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]//button"));
        WebElement menuItem = driver.findElement(By.xpath(xpath));
        builder
                .click(menuButton)
                .click(menuItem)
                .build()
                .perform();
    }

    void checkSumAndEmail() {
        inputFields.checkSumField();
        inputFields.checkEmailField();
    }

    @AfterAll
    static void closeSession() {
        driver.quit();
    }
}
