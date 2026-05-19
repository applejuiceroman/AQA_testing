package lesson_4;

public class Circle implements Shape {
    private double radius;
    private Color color;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.color = new Color (fillColor, borderColor);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return color.fillColor;
    }

    @Override
    public String getBorderColor() {
        return color.borderColor;
    }
}