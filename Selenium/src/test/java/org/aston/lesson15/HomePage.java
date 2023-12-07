package org.aston.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final WebDriver DRIVER;
    private final By PRODUCTS_LIST_LOCATOR = By.xpath("//*[@data-analitics-code='MCS']");
    private final By BASKET_BUTTON_LOCATOR_PC = By.xpath("//*[@class='navbar-pc__icon navbar-pc__icon--basket']");
    private final By BASKET_BUTTON_LOCATOR_MOBILE = By.xpath("//*[@class='navbar-mobile__icon navbar-mobile__icon--basket']");

    public HomePage(WebDriver driver) {
        DRIVER = driver;
    }

    private List<WebElement> getProductsList() {
        return DRIVER.findElements(PRODUCTS_LIST_LOCATOR);
    }

    public void clickToProduct(int productIndex) {
        List<WebElement> productsList = getProductsList();
        if (productIndex >= productsList.size() || productIndex < 0) {
            throw new IllegalStateException("Такого товара нет");
        } else {
            productsList.get(productIndex).click();
        }
    }

    public void clickToBasket() {
        DRIVER.findElement(BASKET_BUTTON_LOCATOR_MOBILE).click();
    }
}
