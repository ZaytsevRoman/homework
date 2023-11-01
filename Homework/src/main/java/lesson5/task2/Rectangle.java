package lesson5.task2;

public class Rectangle extends GeometricFiguresColor implements GeometricFigures{

    private double length;
    private double width;

    public Rectangle(String areaColor, String borderColor, double length, double width) {
        super(areaColor, borderColor);
        this.length = length;
        this.width = width;
    }

    @Override
    public double areaCalculation() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
