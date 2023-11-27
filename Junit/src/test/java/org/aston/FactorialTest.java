package org.aston;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    @DisplayName("Проверка факториала положительных чисел")
    void factorialPositiveNumber() {
        Assertions.assertEquals(1, Factorial.getFactorial(1));
        Assertions.assertEquals(24, Factorial.getFactorial(4));
        Assertions.assertEquals(720, Factorial.getFactorial(6));
        Assertions.assertEquals(3628800, Factorial.getFactorial(10));
    }

    @Test
    @DisplayName("Проверка факториала нуля")
    void factorialOfZero() {
        Assertions.assertEquals(1, Factorial.getFactorial(0));
    }

    @Test
    @DisplayName("Проверка факториала отрицательных чисел")
    void factorialNegativeNumber() {
        Assertions.assertEquals(1, Factorial.getFactorial(-3));
        Assertions.assertEquals(1, Factorial.getFactorial(-1));
        Assertions.assertEquals(1, Factorial.getFactorial(-12));
    }
}
