package lesson_4;

public class CatDogSwimEat {
    public static void main(String[] args) {
        Cat catArnie = new Cat("Арни");
        Cat catRusya = new Cat("Руся");
        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");
        Dog dogSharik = new Dog("Шарик");

        catArnie.run(150);
        catArnie.run(250);
        catArnie.swim(5);

        dogBobik.run(450);
        dogBobik.run(600);
        dogBobik.swim(8);
        dogBobik.swim(15);

        System.out.println("\n");

        Cat[] cats = {
                new Cat("Арни"),
                new Cat("Руся"),
                new Cat("Элиза"),
                new Cat("Ржавый"),
                new Cat("Шлепок")
        };

        Bowl bowl = new Bowl(30);
        bowl.displayFoodAmount();

        int[] eatAmounts = {11, 15, 8, 10, 6};

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, eatAmounts[i]);
            bowl.displayFoodAmount();
            System.out.println();
        }

        // Сыты ли коты?
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " - " + (cat.isFull() ? "сыт(а)" : "голоден(а)"));
        }

        bowl.addFood(26);

        int[] eatAmountsSecondAttempt = {11, 15, 8, 10, 6};

        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isFull()) {
                cats[i].eat(bowl, eatAmountsSecondAttempt[i]);
                bowl.displayFoodAmount();
                System.out.println();
            }
        }

        // Ещё раз — сыты ли коты?
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " - " + (cat.isFull() ? "сыт(а)" : "голоден(а)"));
        }
    }
}
