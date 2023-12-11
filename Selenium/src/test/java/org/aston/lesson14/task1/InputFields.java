package org.aston.lesson14.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputFields {
    private WebDriver driver;
    private final By PHONE_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"connection-phone\"]");
    private final By SUM_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"connection-sum\"]");
    private final By EMAIL_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"connection-email\"]");
    private final By SUBSCRIBER_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"internet-phone\"]");
    private final By ACCOUNT44_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"score-instalment\"]");
    private final By ACCOUNT2073_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"score-arrears\"]");


    InputFields(WebDriver driver) {
        this.driver = driver;
    }

    String getPhoneNumberField() {
        WebElement phoneInputField = driver.findElement(PHONE_INPUT_FIELD_LOCATOR);
        return phoneInputField.getAttribute("placeholder");
    }

    String getSumField() {
        WebElement sumInputField = driver.findElement(SUM_INPUT_FIELD_LOCATOR);
        return sumInputField.getAttribute("placeholder");
    }

    String getEmailField() {
        WebElement emailInputField = driver.findElement(EMAIL_INPUT_FIELD_LOCATOR);
        return emailInputField.getAttribute("placeholder");
    }

    String getSubscriberNumber() {
        WebElement subscriberInputField = driver.findElement(SUBSCRIBER_INPUT_FIELD_LOCATOR);
        return subscriberInputField.getAttribute("placeholder");
    }

    String getAccountNumberBy44() {
        WebElement account44InputField = driver.findElement(ACCOUNT44_INPUT_FIELD_LOCATOR);
        return account44InputField.getAttribute("placeholder");
    }

    String getAccountNumberBy2073() {
        WebElement account2073InputField = driver.findElement(ACCOUNT2073_INPUT_FIELD_LOCATOR);
        return account2073InputField.getAttribute("placeholder");
    }
}
