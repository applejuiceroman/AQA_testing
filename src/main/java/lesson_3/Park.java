package lesson_3;

public class Park {
    public class Attraction {
        public String name;
        public String workHours;
        public double price;

        public Attraction(String name, String workHours, double price) {
            this.name = name;
            this.workHours = workHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println(name + ". Часы работы: " + workHours + ". Цена: " + price + " BYN");
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        Attraction kidsMiniTrain = park.new Attraction("Детский мини-поезд", "10:00-20:00", 2.5);
        Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "11:00-19:00", 4.2);
        Attraction labyrinth = park.new Attraction("Лабиринт", "11:00-19:00", 7);

        kidsMiniTrain.displayInfo();
        ferrisWheel.displayInfo();
        labyrinth.displayInfo();
    }
}
