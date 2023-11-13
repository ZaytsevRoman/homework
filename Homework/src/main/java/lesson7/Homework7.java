package lesson7;

public class Homework7 {

    public static void checkAndSumArrValues(String[][] arr) {
        if (arrayIsCorrect(arr)) {
            sumValues(arr);
        }
    }

    private static boolean arrayIsCorrect(String[][] arr) {
        if (arr.length != 4 || arr[0].length != 4) {
            try {
                throw new MyArraySizeException();
            } catch (MyArraySizeException e) {
                System.out.println("Недопустимый размер массива");
                return false;
            }
        } else return true;
    }

    private static void sumValues(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += parseArrayValues(arr, i, j);
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }

    private static int parseArrayValues(String[][] arr, int i, int j) {
        if (canBeParsed(arr, i, j)) {
            return Integer.parseInt(arr[i][j]);
        } else {
            try {
                throw new MyArrayDataException(i, j);
            } catch (MyArrayDataException e) {
                System.out.println("Недопустимые данные в ячейке: " + e.getCellWithInvalidData());
            }
        }
        return 0;
    }

    private static boolean canBeParsed(String[][] arr, int i, int j) {
        try {
            Integer.parseInt(arr[i][j]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
