package lesson10;

public class Fruit<W extends Number> {

    W weight;

    public Fruit(W weight) {
        this.weight = weight;
    }

    public W getFruitWeight() {
        return weight;
    }
}
