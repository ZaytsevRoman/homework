package lesson10;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruitsInBox = new ArrayList<>();

    public void addOneFruit(T fruit) {
        fruitsInBox.add(fruit);
    }

    public void addAllFruits(Box<T> box) {
        fruitsInBox.addAll(box.getFruitsInBox());
        box.clearFruitsInBox();
    }

    public double getBoxWeight() {
        if (fruitsInBox.size() > 0) {
            return fruitsInBox.size() * fruitsInBox.get(0).getFruitWeight().doubleValue();
        } else {
            return 0;
        }
    }

    public boolean compare(Box box) {
        if (getBoxWeight() == box.getBoxWeight()) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<T> getFruitsInBox() {
        return fruitsInBox;
    }

    public void clearFruitsInBox() {
        fruitsInBox.clear();
    }
}
