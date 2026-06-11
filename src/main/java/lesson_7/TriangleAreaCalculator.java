package lesson_7;

public class TriangleAreaCalculator {
    public static double getAreaByThreeSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Стороны должны быть положительными");
            return -1;
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Треугольник с такими сторонами не существует");
            return -1;
        }

        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return area;
    }

    public static double getAreaByBaseAndHeight(double base, double height) {
        if (base <= 0 || height <= 0) {
            System.out.println("Основание и высота должны быть положительными");
            return -1;
        }

        return (base * height) / 2;
    }
}
