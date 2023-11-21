package lesson9.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayData {

    private ArrayList<String> list = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));

    public void getSortedArray() {
        String[] result = list.stream()
                .sorted(Comparator.comparing(str -> Integer.parseInt(str.substring(1))))
                .toArray(String[]::new);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
