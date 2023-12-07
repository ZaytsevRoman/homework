package org.aston.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private final WebDriver DRIVER;
    private final By SIZE_TABLE_LOCATOR = By.xpath("//*[@class='sizes-table__btn j-wba-card-item']");
    private final By SIZE_LIST_LOCATOR = By.xpath("//*[@class='j-size sizes-list__button']");
    private final By ADD_TO_BASKET_BUTTON_LOCATOR = By.xpath("//*[@aria-label='Добавить в корзину']");
    private final By BACK_BUTTON_LOCATOR = By.xpath("//*[@class='breadcrumbs__back']");
    private final By PRODUCT_NAME_LOCATOR = By.xpath("//*[@data-link='text{:selectedNomenclature^goodsName}']");
    private final By PRODUCT_PRICE_LOCATOR = By.xpath("//*[@class='price-block__final-price']");

    public ProductPage(WebDriver driver) {
        this.DRIVER = driver;
    }

    private boolean checkSizeTable() {
        if (DRIVER.findElements(SIZE_TABLE_LOCATOR).size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private List<WebElement> getSizeList() {
        return DRIVER.findElements(SIZE_LIST_LOCATOR);
    }

    public void addToBasket() {
        if (checkSizeTable()) {
            WebElement sizeButton = getSizeList().get(0);
            JavascriptExecutor executor = (JavascriptExecutor) DRIVER;
            executor.executeScript("arguments[0].scrollIntoView(true);", sizeButton);
            sizeButton.click();
        }
        DRIVER.findElement(ADD_TO_BASKET_BUTTON_LOCATOR).click();
    }

    public void clickBack() {
        DRIVER.findElement(BACK_BUTTON_LOCATOR).click();
    }

    public String getProductName() {
        return DRIVER.findElement(PRODUCT_NAME_LOCATOR).getAttribute("innerText").trim();
    }

    public Integer getProductPrice() {
        String priceString = DRIVER.findElement(PRODUCT_PRICE_LOCATOR).getAttribute("innerText").trim();
        return Integer.parseInt(priceString.replaceAll("\u00a0", "")
                .replaceAll("₽", ""));
    }
}
