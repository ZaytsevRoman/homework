package lesson5.task1;

public class BowlFood {

    private int foodCount;

    public BowlFood(int foodCount) {
        this.foodCount = foodCount;
    }

    public void addFood(int food) {
        foodCount = foodCount + food;
    }

    public void reduceFood(int food) {
        foodCount = foodCount - food;
    }

    public int getFoodCount() {
        return foodCount;
    }
}
