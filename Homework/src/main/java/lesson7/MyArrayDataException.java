package lesson7;

public class MyArrayDataException extends Exception {

    private String cellWithInvalidData;

    public MyArrayDataException(int lineNumber, int columnNumber) {
        this.cellWithInvalidData = "[" + lineNumber + ", " + columnNumber + "]";
    }

    public String getCellWithInvalidData() {
        return cellWithInvalidData;
    }
}
