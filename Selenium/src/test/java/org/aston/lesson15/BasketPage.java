package org.aston.lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasketPage {
    private final WebDriver DRIVER;
    private final By PRODUCTS_NAMES_LOCATOR = By.xpath("//*[@class='good-info__good-name']");
    private final By PRODUCTS_PRICE_LOCATOR = By.xpath("//*[@class='list-item__price-new']");
    private final By COUNT_PLUS_BUTTON_LOCATOR = By.xpath("//*[@class='count__plus plus']");
    private final By COUNT_MINUS_BUTTON_LOCATOR = By.xpath("//*[@class='count__minus minus']");
    private final By SUM_LOCATOR = By.xpath("//*[@class='b-right']");
    private final By COUNT_LOCATOR = By.xpath("//*[@class='in_tb j-tb-qnt count__numeric ignore']");
    private List<String> expectedProductsNameList;
    private List<Integer> expectedProductsPriceList;
    private Integer countPrice = 1;

    public BasketPage(WebDriver driver) {
        DRIVER = driver;
        expectedProductsNameList = new ArrayList<>();
        expectedProductsPriceList = new ArrayList<>();
    }

    public void addProductName(String productName) {
        expectedProductsNameList.add(productName);
    }

    public List<String> getExpectedProductsNameList() {
        return expectedProductsNameList.stream().sorted().collect(Collectors.toList());
    }

    public List<String> getActualProductsNameList() {
        return DRIVER.findElements(PRODUCTS_NAMES_LOCATOR).stream()
                .map(element -> element.getAttribute("innerText").trim()).sorted().collect(Collectors.toList());
    }

    public List<Integer> getExpectedProductsPriceList() {
        int index = expectedProductsPriceList.size() - (WildberriesTest.productIndexToChangeCount + 1);
        expectedProductsPriceList.set(index, expectedProductsPriceList.get(index) * countPrice);
        return expectedProductsPriceList.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getActualProductsPriceList() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return DRIVER.findElements(PRODUCTS_PRICE_LOCATOR).stream()
                .map(element -> element.getAttribute("innerText"))
                .map(p -> p.replaceAll("\u00a0", "")
                        .replaceAll("₽", ""))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public void addProductPrice(Integer productPrice) {
        expectedProductsPriceList.add(productPrice);
    }

    public Integer getExpectedProductsPriceSum() {
        return expectedProductsPriceList.stream()
                .flatMapToInt(IntStream::of)
                .sum();
    }

    public Integer getActualProductsPriceSum() {
        String sumString = DRIVER.findElement(SUM_LOCATOR).getAttribute("innerText");
        return Integer.parseInt(sumString.replaceAll("\u00a0", "")
                .replaceAll("₽", ""));
    }

    public void clickCountPlus(int productIndex) {
        DRIVER.findElements(COUNT_PLUS_BUTTON_LOCATOR).get(productIndex).click();
        countPrice++;
    }

    public void clickCountMinus() {
        DRIVER.findElement(COUNT_MINUS_BUTTON_LOCATOR).click();
        countPrice--;
    }

    public Integer getCount() {
        return countPrice;
    }

    public Integer getActualProductsCount(int productIndex) {
        return Integer.parseInt(DRIVER.findElements(COUNT_LOCATOR).get(productIndex).getAttribute("value"));
    }
}
