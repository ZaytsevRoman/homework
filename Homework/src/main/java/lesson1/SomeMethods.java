package lesson1;

public class SomeMethods {

    public void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    public void checkSumSign() {
        int a = -6;
        int b = 5;
        System.out.println(a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public void printColor() {
        int value = 101;
        String result;
        if (value <= 0) {
            result = "Красный";
        } else if (value > 0 && value <= 100) {
            result = "Желтый";
        } else {
            result = "Зеленый";
        }
        System.out.println(result);
    }

    public void compareNumbers() {
        int a = 15;
        int b = -55;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
