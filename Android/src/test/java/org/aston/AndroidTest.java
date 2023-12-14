package org.aston;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AndroidTest {
    private static AndroidDriver driver;
    private static Calculator calculator;

    @BeforeAll
    static void initialize() {
        driver = AndroidDriverInstance.getInstance();
        calculator = new Calculator(driver);
    }

    @AfterEach
    void clear() {
        calculator.clear();
    }

    @ParameterizedTest
    @DisplayName("Проверка суммирования чисел")
    @CsvSource({"12, 333", "-4, 0", "19, -5"})
    void checkAddition(int first, int second) {
        Assertions.assertEquals(calculator.getExpectedAddition(first, second), calculator.getActualAddition(first, second));
    }

    @ParameterizedTest
    @DisplayName("Проверка вычитания чисел")
    @CsvSource({"2, 3", "-12, 61", "0, 2121"})
    void checkSubtraction(int first, int second) {
        Assertions.assertEquals(calculator.getExpectedSubtraction(first, second), calculator.getActualSubtraction(first, second));
    }

    @ParameterizedTest
    @DisplayName("Проверка деления чисел")
    @CsvSource({"2, 3", "96, -6", "3, 0"})
    void checkDivision(int first, int second) {
        if (second == 0) {
            Assertions.assertEquals("Can't divide by 0", calculator.getDivisionByZero(first, second));
        } else {
            Assertions.assertEquals(calculator.getExpectedDivision(first, second), calculator.getActualDivision(first, second));
        }
    }

    @ParameterizedTest
    @DisplayName("Проверка умножения чисел")
    @CsvSource({"2, 3", "-44, -6", "0, 111"})
    void checkMultiplication(int first, int second) {
        Assertions.assertEquals(calculator.getExpectedMultiplication(first, second), calculator.getActualMultiplication(first, second));
    }
}
