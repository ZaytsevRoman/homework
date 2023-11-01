package lesson5.task1;

public class Cat extends Animal{

    private static int count = 0;
    private boolean fullness = false;

    public Cat(String name) {
        super(name);
        this.count += 1;
    }

    public void run(int length) {
        if (length > 200) {
            System.out.println("Длинна слишком большая для " + name);
        } else {
            super.run(length);
        }
    }

    public void swim(int length) {
        System.out.println(name + " не умеет плавать");
    }

    public static void getCatsCount() {
        System.out.println("Количество созданных котов: " + count);
    }

    public void eat(int food, BowlFood bowlFood) {
        if (bowlFood.getFoodCount() >= food) {
            fullness = true;
            bowlFood.reduceFood(food);
        }
    }

    public boolean isFullness() {
        return fullness;
    }
}
