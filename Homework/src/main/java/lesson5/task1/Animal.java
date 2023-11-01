package lesson5.task1;

public class Animal {

    private static int count = 0;
    String name;

    public Animal(String name) {
        this.name = name;
        this.count += 1;
    }

    public void run(int length) {
        if (length > 0) {
            System.out.println(name + " пробежал(а) " + length + " м");
        } else {
            System.out.println("Неправильная длинна");
        }
    }

    public void swim(int length) {
        if (length > 0) {
            System.out.println(name + " проплыл(а) " + length + " м");
        } else {
            System.out.println("Неправильная длинна");
        }
    }

    public static void getAnimalsCount() {
        System.out.println("Количество созданных животных: " + count);;
    }
}
