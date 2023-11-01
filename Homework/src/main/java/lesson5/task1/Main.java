package lesson5.task1;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Лаки");
        cat1.run(200);
        cat1.swim(5);

        Dog dog1 = new Dog("Шарик");
        dog1.run(501);
        dog1.swim(5);

        Dog dog2 = new Dog("Тузик");
        dog2.run(100);
        dog2.swim(15);

        Animal.getAnimalsCount();
        Cat.getCatsCount();
        Dog.getDogsCount();

        BowlFood bowlFood = new BowlFood(6);
        bowlFood.addFood(2);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Васька");
        cats[2] = new Cat("Муська");

        for (Cat c : cats) {
            c.eat(3, bowlFood);
            System.out.println(c.name + " сытость: " + c.isFullness() +
                    "\n" + "Остаток в миске: " + bowlFood.getFoodCount());
        }
    }
}
