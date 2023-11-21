package lesson9.task1;

import java.util.stream.Stream;

public class EvenNumbersPrinter {

    public static void printingEvenNumbers(ArrayGenerator arrayGenerator) {
        long count = Stream.of(arrayGenerator.getNumbers())
                .filter(n -> n % 2 == 0).count();
        System.out.println("Количество четных чисел: " + count);
    }
}
