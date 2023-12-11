package org.aston.lesson14.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopUpOnlineFrame {
    private WebDriver driver;
    private final String SENT_SUM = "1.3";
    private final String PHONE_NUMBER_SENT = "297777777";
    private final String EMAIL_SENT = "test@test.com";
    private final int TIME_OUT = 3000;
    private final By PHONE_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"connection-phone\"]");
    private final By SUM_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"connection-sum\"]");
    private final By EMAIL_INPUT_FIELD_LOCATOR = By.xpath("//*[@id=\"connection-email\"]");
    private final By PROCEED_BUTTON_LOCATOR = By.xpath("//*[@id=\"pay-connection\"]/button");
    private final By FRAME_LOCATOR = By.xpath("//div/iframe");
    private final By SUM_IN_HEADER_LOCATOR = By.xpath("//app-header/header/div/div/p[1]");
    private final By SUM_IN_BUTTON_LOCATOR = By.xpath("//app-card-page/div/div[1]/button");
    private final By PHONE_NUMBER_LOCATOR = By.xpath("//app-header/header/div/div/p[2]");
    private final By INPUT_FIELDS_LOCATOR = By.xpath("//app-input/div/div/div[1]/label");
    private final By ICONS_LOCATOR = By.xpath("//app-input/div/div/div[2]/div/div//img");

    TopUpOnlineFrame(WebDriver driver) {
        this.driver = driver;
        openFrame();
    }

    void openFrame() {
        WebElement phoneInputField = driver.findElement(PHONE_INPUT_FIELD_LOCATOR);
        phoneInputField.sendKeys(PHONE_NUMBER_SENT);
        WebElement sumInputField = driver.findElement(SUM_INPUT_FIELD_LOCATOR);
        sumInputField.sendKeys(SENT_SUM);
        WebElement emailInputField = driver.findElement(EMAIL_INPUT_FIELD_LOCATOR);
        emailInputField.sendKeys(EMAIL_SENT);
        WebElement button = driver.findElement(PROCEED_BUTTON_LOCATOR);
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(FRAME_LOCATOR));
        driver.switchTo().frame(driver.findElement(FRAME_LOCATOR));
    }

    double getSumInFrameHeader() {
        String textInHeader = driver.findElement(SUM_IN_HEADER_LOCATOR).getAttribute("innerText");
        String[] textInHeaderArray = textInHeader.split(" ");
        return Double.valueOf(textInHeaderArray[0]);
    }

    double getSumInFrameButton() {
        String textInButton = driver.findElement(SUM_IN_BUTTON_LOCATOR).getAttribute("innerText");
        String[] textInButtonArray = textInButton.split(" ");
        return Double.valueOf(textInButtonArray[1]);
    }

    String getPhoneNumberInFrame() {
        String text = driver.findElement(PHONE_NUMBER_LOCATOR).getAttribute("innerText");
        return text.substring(text.length() - PHONE_NUMBER_SENT.length());
    }

    List<String> getActualFields() {
        return driver.findElements(INPUT_FIELDS_LOCATOR).stream()
                .map(e -> e.getAttribute("innerText"))
                .collect(Collectors.toList());
    }

    List<Integer> getIconsResponseCodes() {
        List<String> iconsUrls = driver.findElements(ICONS_LOCATOR).stream()
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
        return iconsResponseCodes;
    }

    public String getSentSum() {
        return SENT_SUM;
    }

    public String getPhoneNumberSent() {
        return PHONE_NUMBER_SENT;
    }
}
