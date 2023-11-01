package lesson5.task1;

public class Dog extends Animal{

    private static int count = 0;

    public Dog(String name) {
        super(name);
        this.count += 1;
    }

    public void run(int length) {
        if (length > 500) {
            System.out.println("Длинна слишком большая для " + name);
        } else {
            super.run(length);
        }
    }

    public void swim(int length) {
        if (length > 10) {
            System.out.println("Длинна слишком большая для " + name);
        } else {
            super.swim(length);
        }
    }

    public static void getDogsCount() {
        System.out.println("Количество созданных собак: " + count);
    }
}
