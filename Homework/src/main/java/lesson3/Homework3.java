package lesson3;

import java.util.Arrays;

public class Homework3 {

    public boolean checkAmount(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public void checkPositiveNumber(int a) {
        String result;
        if (a >= 0) {
            result = "Число положительное";
        } else {
            result = "Число отрицательное";
        }
        System.out.println(result);
    }

    public boolean checkPositiveNumberBoolean(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void printText(String text, int a) {
        for (int i = 1; i <= a; i++) {
            System.out.println(text);
        }
    }

    public boolean checkYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 != 0 && year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void changeArray() {
        int[] array = {1, 1, 0, 1, 0, 0, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void writeArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public void changeArrayIfValueLessSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void writeDiagonalsOfArray() {
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }
            }
        }
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
