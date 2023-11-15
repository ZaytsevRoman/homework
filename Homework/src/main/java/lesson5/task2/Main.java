package lesson5.task2;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        Circle[] circles = new Circle[3];
        circles[0] = new Circle("red", "black", 5);
        circles[1] = new Circle("blue", "white", 3);
        circles[2] = new Circle("yellow", "green", 20);

        for (Circle c : circles) {
            String formattedPerimeter = new DecimalFormat("#0.00").format(c.perimeterCalculation());
            String formattedArea = new DecimalFormat("#0.00").format(c.areaCalculation());
            System.out.println("Периметр: " + formattedPerimeter + " площадь: " + formattedArea +
                    " цвет фона: " + c.areaColor + " цвет границ: " + c.borderColor);
        }

        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = new Rectangle("blue", "red", 3, 2);
        rectangles[1] = new Rectangle("black", "white", 12, 9);

        for (Rectangle r : rectangles) {
            System.out.println("Периметр: " + r.perimeterCalculation()
                    + " площадь: " + r.areaCalculation() + " цвет фона: " + r.areaColor +
                    " цвет границ: " + r.borderColor);
        }

        Triangle[] triangles = new Triangle[2];
        triangles[0] = new Triangle("green", "white", 3, 4, 5);
        triangles[1] = new Triangle("black", "blue", 10, 21, 19);

        for (Triangle t : triangles) {
            String formattedPerimeter = new DecimalFormat("#0.00")
                    .format(t.perimeterCalculation());
            String formattedArea = new DecimalFormat("#0.00").format(t.areaCalculation());
            System.out.println("Периметр: " + formattedPerimeter + " площадь: " + formattedArea +
                    " цвет фона: " + t.areaColor + " цвет границ: " + t.borderColor);
        }
    }
}
