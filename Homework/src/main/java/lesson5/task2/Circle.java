package lesson5.task2;

public class Circle extends GeometricFigure implements GeometricFigures{

    private double radius;

    public Circle(String areaColor, String borderColor, double radius) {
        super(areaColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double areaCalculation() {
        return Pi * radius * radius;
    }

    @Override
    public double perimeterCalculation() {
        return 2 * Pi * radius;
    }
}
