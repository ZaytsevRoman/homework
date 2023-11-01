package lesson5.task2;

public class Triangle extends GeometricFiguresColor implements GeometricFigures{

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
        double p = perimeterCalculation(a, b, c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
