package lesson10;

public class Main {
    public static void main(String[] args) {

        Box<Apple> boxApple = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        boxApple.addOneFruit(apple1);
        boxApple.addOneFruit(apple2);
        boxApple.addOneFruit(apple3);
        System.out.println("Вес коробки с яблоками: " + boxApple.getBoxWeight());

        Box<Orange> boxOrange = new Box<>();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        boxOrange.addOneFruit(orange1);
        boxOrange.addOneFruit(orange2);
        System.out.println("Вес коробки с апельсинами: " + boxOrange.getBoxWeight());

        Box<Apple> emptyBox = new Box<>();
        System.out.println("Вес пустой коробки: " + emptyBox.getBoxWeight());

        System.out.println("Равен ли вес у коробок(яблок-апельсин): " + boxApple.compare(boxOrange));
        System.out.println("Равен ли вес у коробок(яблок-пустой): " + boxApple.compare(emptyBox));

        Box<Apple> boxApple2 = new Box<>();
        boxApple2.addOneFruit(apple1);
        boxApple2.addOneFruit(apple2);

        boxApple.addAllFruits(boxApple2);
        System.out.println("Вес коробки с яблоками-1 после пересыпания: " + boxApple.getBoxWeight());
        System.out.println("Вес коробки с яблоками-2 после пересыпания: " + boxApple2.getBoxWeight());

    }
}
