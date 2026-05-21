package lesson_4;

public class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    protected static int animalCount = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit && distance > 0) {
            System.out.println(name + " пробежал " + distance + "м");
        } else if (distance <= 0) {
            System.out.println(name + " не может пробежать отрицательное или нулевое расстояние");
        } else {
            System.out.println(name + " не может пробежать " + distance + "м");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать");
        } else if (distance <= swimLimit && distance > 0) {
            System.out.println(name + " проплыл " + distance + "м");
        } else if (distance <= 0) {
            System.out.println(name + " не может проплыть отрицательное или нулевое расстояние");
        } else {
            System.out.println(name + " не может проплыть " + distance + "м");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }
}
