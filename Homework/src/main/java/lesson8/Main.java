package lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] arrWords = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                "два", "пять", "восемь", "восемь", "одиннадцать"};

        HashSet<String> uniqueWordsList = new HashSet<>(List.of(arrWords));
        System.out.println("Список уникальных слов: " + uniqueWordsList);

        ArrayList<String> wordsList = new ArrayList<>(List.of(arrWords));
        HashMap<String, Integer> wordsListWithCount = new HashMap<>();
        for (int i = 0; i < wordsList.size(); i++) {
            int count = 0;
            for (int j = 0; j < wordsList.size(); j++) {
                if (wordsList.get(i).equals(wordsList.get(j))) {
                    count++;
                }
            }
            wordsListWithCount.put(wordsList.get(i), count);
        }
        System.out.println("Список с количеством повторений слов: " + wordsListWithCount);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "233-333");
        phonebook.add("Петров", "23-33-44");
        phonebook.add("Сидоров", "8-913-33333");
        phonebook.add("Иванов", "6699 933 22");
        phonebook.add("Иванов", "+7-999-231-33-12");
        phonebook.get("Иванов");
    }
}
