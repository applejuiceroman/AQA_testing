package lesson_4;

public class Rectangle implements Shape {
    private double width;
    private double height;
    private Color color;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.color = new Color (fillColor, borderColor);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
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
