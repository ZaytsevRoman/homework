package lesson5.task2;

public class Circle extends GeometricFiguresColor implements GeometricFigures{

    private double radius;

    public Circle(String areaColor, String borderColor, double radius) {
        super(areaColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double areaCalculation() {
        return Pi * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}
