package lesson_4;

public class TriSqRecShapeColor {
    public static void main(String[] args) {

        Circle circle = new Circle(6.0, "Желтый", "Розовый");
        Rectangle rectangle = new Rectangle(5.5, 6.1, "Голубой", "Фиолетовый");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Светло-зеленый", "Синий");

        System.out.println("----- Круг -----");
        System.out.println("Радиус: 5.0");
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Длина окружности: " + circle.getPerimeter());
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());
        System.out.println();

        System.out.println("----- Прямоугольник -----");
        System.out.println("Ширина: 4.0, Высота: 6.0");
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());
        System.out.println();

        System.out.println("----- Треугольник -----");
        System.out.println("Стороны: 3.0, 4.0, 5.0");
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
    }
}
