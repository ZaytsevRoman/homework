package org.aston;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final AndroidDriver DRIVER;
    private final By BUTTON_ONE_LOCATOR = By.id("com.google.android.calculator:id/digit_1");
    private final By BUTTON_TWO_LOCATOR = By.id("com.google.android.calculator:id/digit_2");
    private final By BUTTON_THREE_LOCATOR = By.id("com.google.android.calculator:id/digit_3");
    private final By BUTTON_FOUR_LOCATOR = By.id("com.google.android.calculator:id/digit_4");
    private final By BUTTON_FIVE_LOCATOR = By.id("com.google.android.calculator:id/digit_5");
    private final By BUTTON_SIX_LOCATOR = By.id("com.google.android.calculator:id/digit_6");
    private final By BUTTON_SEVEN_LOCATOR = By.id("com.google.android.calculator:id/digit_7");
    private final By BUTTON_EIGHT_LOCATOR = By.id("com.google.android.calculator:id/digit_8");
    private final By BUTTON_NINE_LOCATOR = By.id("com.google.android.calculator:id/digit_9");
    private final By BUTTON_ZERO_LOCATOR = By.id("com.google.android.calculator:id/digit_0");
    private final By BUTTON_ADDITION_LOCATOR = By.id("com.google.android.calculator:id/op_add");
    private final By BUTTON_SUBTRACTION_LOCATOR = By.id("com.google.android.calculator:id/op_sub");
    private final By BUTTON_DIVISION_LOCATOR = By.id("com.google.android.calculator:id/op_div");
    private final By BUTTON_MULTIPLICATION_LOCATOR = By.id("com.google.android.calculator:id/op_mul");
    private final By BUTTON_EQUALS_LOCATOR = By.id("com.google.android.calculator:id/eq");
    private final By RESULT_LOCATOR = By.id("com.google.android.calculator:id/result_final");
    private final By RESULT_PREVIEW_LOCATOR = By.id("com.google.android.calculator:id/result_preview");
    private final By CLEAR_LOCATOR = By.id("com.google.android.calculator:id/clr");
    private List<By> numberButtonLocators = new ArrayList<>(
            Arrays.asList(BUTTON_ZERO_LOCATOR, BUTTON_ONE_LOCATOR, BUTTON_TWO_LOCATOR, BUTTON_THREE_LOCATOR,
                    BUTTON_FOUR_LOCATOR, BUTTON_FIVE_LOCATOR, BUTTON_SIX_LOCATOR,
                    BUTTON_SEVEN_LOCATOR, BUTTON_EIGHT_LOCATOR, BUTTON_NINE_LOCATOR));

    public Calculator(AndroidDriver driver) {
        DRIVER = driver;
    }

    public void clear() {
        DRIVER.findElement(CLEAR_LOCATOR).click();
    }

    public int getExpectedAddition(int first, int second) {
        return first + second;
    }

    public int getActualAddition(int first, int second) {
        calculate(first, second, BUTTON_ADDITION_LOCATOR);
        return Integer.parseInt(getResult());
    }

    public int getExpectedSubtraction(int first, int second) {
        return first - second;
    }

    public int getActualSubtraction(int first, int second) {
        calculate(first, second, BUTTON_SUBTRACTION_LOCATOR);
        return Integer.parseInt(getResult());
    }

    public double getExpectedDivision(double first, double second) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#############");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(decimalFormat.format(first / second).replace(",", "."));
    }

    public double getActualDivision(int first, int second) {
        calculate(first, second, BUTTON_DIVISION_LOCATOR);
        return Double.parseDouble(getResult());
    }

    public int getExpectedMultiplication(int first, int second) {
        return first * second;
    }

    public int getActualMultiplication(int first, int second) {
        calculate(first, second, BUTTON_MULTIPLICATION_LOCATOR);
        return Integer.parseInt(getResult());
    }

    public String getDivisionByZero(int first, int second) {
        calculate(first, second, BUTTON_DIVISION_LOCATOR);
        return DRIVER.findElement(RESULT_PREVIEW_LOCATOR).getText();
    }

    private void enterNumber(int number) {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            String charAtString = String.valueOf(numberString.charAt(i));
            if (charAtString.equals("-")) {
                DRIVER.findElement(BUTTON_SUBTRACTION_LOCATOR).click();
            } else {
                DRIVER.findElement(numberButtonLocators.get(Integer.parseInt(charAtString))).click();
            }
        }
    }

    private void calculate(int first, int second, By locator) {
        enterNumber(first);
        DRIVER.findElement(locator).click();
        enterNumber(second);
        DRIVER.findElement(BUTTON_EQUALS_LOCATOR).click();
    }

    private String getResult() {
        return DRIVER.findElement(RESULT_LOCATOR).getText().replace("\u2212", "-");
    }
}
