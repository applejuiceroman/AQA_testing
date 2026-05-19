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
}
