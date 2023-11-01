package lesson5.task2;

public interface GeometricFigures {

    double Pi = 3.1415;

    double areaCalculation();

    default double perimeterCalculation(double a, double b, double c){
        return a + b + c;
    }

    default double perimeterCalculation(double length, double width){
        return 2 * (length + width);
    }

    default double perimeterCalculation(double radius){
        return 2 * Pi * radius;
    }
}