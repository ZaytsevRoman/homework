package org.aston;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest extends Assert {

    @Test(description = "Проверка факториала положительных чисел")
    void factorialPositiveNumber() {
        assertEquals(1, Factorial.getFactorial(1));
        assertEquals(24, Factorial.getFactorial(4));
        assertEquals(720, Factorial.getFactorial(6));
        assertEquals(3628800, Factorial.getFactorial(10));
    }

    @Test(description = "Проверка факториала нуля")
    void factorialOfZero() {
        assertEquals(1, Factorial.getFactorial(0));
    }

    @Test(description = "Проверка факториала отрицательных чисел")
    void factorialNegativeNumber() {
        assertEquals(1, Factorial.getFactorial(-3));
        assertEquals(1, Factorial.getFactorial(-1));
        assertEquals(1, Factorial.getFactorial(-12));
    }
}
