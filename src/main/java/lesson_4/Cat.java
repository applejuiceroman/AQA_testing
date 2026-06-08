package lesson_4;

public class Cat extends Animal {
    private boolean isFull;
    private static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (isFull) {
            System.out.println(name + " не хочет есть");
            return;
        }

        if (bowl.getFoodAmount() >= amount) {
            bowl.takeFood(amount);
            isFull = true;
            System.out.println(name + " поел(а) " + amount + " еды и теперь сыт(а)");
        } else {
            System.out.println(name + " не поел(а), так как в миске недостаточно еды");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
}