package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Homework2 homework2 = new Homework2();

        System.out.println(homework2.checkAmount(0,-14));

        homework2.checkPositiveNumber(-0);

        System.out.println(homework2.checkPositiveNumberBoolean(-10));

        homework2.printText("test", 4);

        System.out.println(homework2.checkYear(2104));

        homework2.changeArray();

        homework2.writeArray();

        homework2.changeArrayIfValueLessSix();

        homework2.writeDiagonalsOfArray();

        System.out.println(Arrays.toString(homework2.getArray(5, 11)));
    }
}
