package lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Homework3 homework3 = new Homework3();

        System.out.println(homework3.checkAmount(0,-14));

        homework3.checkPositiveNumber(-0);

        System.out.println(homework3.checkPositiveNumberBoolean(-10));

        homework3.printText("test", 4);

        System.out.println(homework3.checkYear(2104));

        homework3.changeArray();

        homework3.writeArray();

        homework3.changeArrayIfValueLessSix();

        homework3.writeDiagonalsOfArray();

        System.out.println(Arrays.toString(homework3.getArray(5, 11)));
    }
}
