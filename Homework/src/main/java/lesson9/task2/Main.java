package lesson9.task2;

public class Main {
    public static void main(String[] args) {

        WordsData wordsData = new WordsData();
        CollectionMethods.getCountSearchWord(wordsData.getListWords(), "High");
        CollectionMethods.getCountSearchWord(wordsData.getEmptyList(), "High");

        CollectionMethods.getFirstWord(wordsData.getListWords());
        CollectionMethods.getFirstWord(wordsData.getEmptyList());

        CollectionMethods.getLastWord(wordsData.getListWords());
        CollectionMethods.getLastWord(wordsData.getEmptyList());
    }
}
