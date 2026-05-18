package lesson_4;

public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        if (initialFood >= 0) {
            this.foodAmount = initialFood;
        } else {
            this.foodAmount = 0;
            System.out.println("В миске не может быть меньше 0 еды");
        }
    }

    public void addFood(int amount) {
        System.out.println("\n");
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды");
        } else {
            System.out.println("Нельзя добавить 0 еды или отрицательное количество");
        }
    }

    public void takeFood(int amount) {
        if (amount <= foodAmount && amount > 0) {
            foodAmount -= amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void displayFoodAmount() {
        System.out.println("В миске " + foodAmount + " еды.");
    }
}
