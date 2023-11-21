package lesson9.task2;

import java.util.ArrayList;
import java.util.Optional;

public class CollectionMethods {

    public static void getCountSearchWord(ArrayList<String> listWords, String searchWord) {
        long count = listWords.stream()
                .filter(w -> w.equals(searchWord))
                .count();
        System.out.println("Слово - " + searchWord + " встречается в коллекции: " + count + " раз(а)");
    }

    public static void getFirstWord(ArrayList<String> listWords) {
        Optional<String> firstWord = listWords.stream().findFirst();
        System.out.println("Первый элемент коллекции: " + firstWord.orElse("отсутствует (0)"));
    }

    public static void getLastWord(ArrayList<String> listWords) {
        if (listWords.size() > 0) {
            listWords.stream()
                    .skip(listWords.size() - 1)
                    .forEach(w -> System.out.println("Последний элемент коллекции: " + w));
        } else {
            System.out.println("Последний элемент коллекции: отсутствует (0)");
        }
    }
}
