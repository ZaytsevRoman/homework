package lesson9.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class WordsData {

    private ArrayList<String> listWords = new ArrayList<>(Arrays.asList("HighLoad", "High", "Load", "HighLoad"));
    private ArrayList<String> emptyList = new ArrayList<>();

    public ArrayList<String> getListWords() {
        return listWords;
    }

    public ArrayList<String> getEmptyList() {
        return emptyList;
    }
}
