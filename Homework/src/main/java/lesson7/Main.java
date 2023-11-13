package lesson7;

public class Main {
    public static void main(String[] args) {

        String[][] arr4x4 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arr4x3 = {{"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}};
        String[][] arr3x4 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arr4x4WithText = {{"sss", "2", "3", "4"}, {"1", "ddd", "3", "4"},
                {"1", "2", "3", "fff"}, {"1", "2", "ggg", "4"}};

        Homework7.checkAndSumArrValues(arr4x4);
        Homework7.checkAndSumArrValues(arr4x3);
        Homework7.checkAndSumArrValues(arr3x4);
        Homework7.checkAndSumArrValues(arr4x4WithText);
    }
}
