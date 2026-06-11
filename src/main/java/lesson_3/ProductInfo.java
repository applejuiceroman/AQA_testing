package lesson_3;

public class ProductInfo {
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
