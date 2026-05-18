package lesson_3;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean isReservedByBuyer;

    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, int price, boolean isReservedByBuyer) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReservedByBuyer = isReservedByBuyer;
    }

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " BYN");
        System.out.println("Состояние бронирования покупателем: " + (isReservedByBuyer ? "Забронирован" : "Не забронирован"));
    }

    public static void main (String[] args) {
        Product laptop = new Product("Ноутбук точно не для игр", "15.05.2025",
                "Lenovo Group Ltd.", "Китай", 4570, false);
        laptop.displayInfo();
        System.out.println();

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Корея", 5599, true);

        productsArray[1] = new Product("iPhone 16 Pro Max", "01.03.2025",
                "Apple Inc.", "США", 5820, false);

        productsArray[2] = new Product("Xiaomi 14 Ultra", "01.01.2025",
                "Xiaomi Corp.", "Китай", 4769, true);

        productsArray[3] = new Product("Google Pixel 9 Pro", "01.02.2025",
                "Google LLC", "США", 5400, false);

        productsArray[4] = new Product("OnePlus 12", "01.03.2025",
                "OnePlus Technology", "Китай", 4490, true);
    }
}
