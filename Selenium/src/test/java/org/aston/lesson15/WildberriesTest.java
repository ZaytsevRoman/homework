package org.aston.lesson15;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class WildberriesTest {
    private static WebDriver driver;
    private static BasketPage basketPage;
    private static HomePage homePage;
    private static ProductPage productPage;
    private static Integer[] productIndexesToAddInBasket = {2, 3, 8};
    static Integer productIndexToChangeCount = 1;

    @BeforeAll
    static void startSession() {
        driver = WebDriverInstance.getInstance();
        driver.get("https://www.wildberries.ru/");
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        addProducts(productIndexesToAddInBasket);
        homePage.clickToBasket();
    }

    static void addProducts(Integer[] indexes) {
        for (Integer index : indexes) {
            homePage.clickToProduct(index);
            basketPage.addProductName(productPage.getProductName());
            basketPage.addProductPrice(productPage.getProductPrice());
            productPage.addToBasket();
            productPage.clickBack();
        }
    }

    @Test
    @DisplayName("Проверка соответствия названия товаров")
    void checkProductsNames() {
        Assertions.assertEquals(basketPage.getExpectedProductsNameList(), basketPage.getActualProductsNameList());
    }

    @Test
    @DisplayName("Проверка соответствия цен товаров")
    void checkProductsPrice() {
        Assertions.assertEquals(basketPage.getExpectedProductsPriceList(), basketPage.getActualProductsPriceList());
    }

    @Test
    @DisplayName("Проверка соответствия суммы цен товаров")
    void checkProductsPriceSum() {
        Assertions.assertEquals(basketPage.getExpectedProductsPriceSum(), basketPage.getActualProductsPriceSum());
    }

    @Test
    @DisplayName("Проверка соответствия количества товаров")
    void checkProductsCount() {
        basketPage.clickCountPlus(productIndexToChangeCount);
        basketPage.clickCountPlus(productIndexToChangeCount);
        basketPage.clickCountMinus();
        Assertions.assertEquals(basketPage.getCount(), basketPage.getActualProductsCount(productIndexToChangeCount));
    }

    @AfterAll
    static void closeSession() {
        driver.quit();
    }
}
