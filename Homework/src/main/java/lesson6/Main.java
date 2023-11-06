package lesson6;

public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData();
        appData.setHeader(new String[]{"Value 1", "Value 2", "Value 3", "Value 4"});
        appData.setData(new int[][]{{1, 2, 3, 4}, {4, 5, 6}, {4, 5, 6, 9, 10}, {4, 5}});

        CsvWriter.write(appData, "1.csv");
        CsvReader.read("2.csv");
    }
}
