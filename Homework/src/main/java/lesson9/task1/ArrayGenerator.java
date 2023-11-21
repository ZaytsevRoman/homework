package lesson9.task1;

import java.util.Random;

public class ArrayGenerator {

    private int arrayLength;
    private Integer[] numbers;

    public ArrayGenerator(int arrayLength) {
        this.arrayLength = arrayLength;
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        numbers = new Integer[arrayLength];
        int number;
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            number = random.nextInt();
            numbers[i] = number;
        }
    }

    public Integer[] getNumbers() {
        return numbers;
    }
}
