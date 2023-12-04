package org.aston.lesson14.task1;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputFields {

    private WebDriver driver;

    InputFields(WebDriver driver) {
        this.driver = driver;
    }

    void checkPhoneNumberField() {
        WebElement phoneInputField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        Assertions.assertEquals("Номер телефона", phoneInputField.getAttribute("placeholder"));
    }

    void checkSumField() {
        WebElement sumInputField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        Assertions.assertEquals("Сумма", sumInputField.getAttribute("placeholder"));
    }

    void checkEmailField() {
        WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        Assertions.assertEquals("E-mail для отправки чека", emailInputField.getAttribute("placeholder"));
    }

    void checkSubscriberNumber() {
        WebElement subscriberInputField = driver.findElement(By.xpath("//*[@id=\"internet-phone\"]"));
        Assertions.assertEquals("Номер абонента", subscriberInputField.getAttribute("placeholder"));
    }

    void checkAccountNumberBy44() {
        WebElement account44InputField = driver.findElement(By.xpath("//*[@id=\"score-instalment\"]"));
        Assertions.assertEquals("Номер счета на 44", account44InputField.getAttribute("placeholder"));
    }

    void checkAccountNumberBy2073() {
        WebElement account2073InputField = driver.findElement(By.xpath("//*[@id=\"score-arrears\"]"));
        Assertions.assertEquals("Номер счета на 2073", account2073InputField.getAttribute("placeholder"));
    }
}
