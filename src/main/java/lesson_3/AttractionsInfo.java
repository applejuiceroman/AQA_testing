package lesson_3;

public class AttractionsInfo {
    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction kidsMiniTrain = park.new Attraction("Детский мини-поезд", "10:00-20:00", 2.5);
        Park.Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "11:00-19:00", 4.2);
        Park.Attraction labyrinth = park.new Attraction("Лабиринт", "11:00-19:00", 7);

        kidsMiniTrain.displayInfo();
        ferrisWheel.displayInfo();
        labyrinth.displayInfo();
    }
}
