package lesson5.task2;

public class Triangle extends GeometricFigure implements GeometricFigures{

    private double a;
    private double b;
    private double c;

    public Triangle(String areaColor, String borderColor, double a, double b, double c) {
        super(areaColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double areaCalculation() {
        double p = perimeterCalculation() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimeterCalculation() {
        return a + b + c;
    }
}
