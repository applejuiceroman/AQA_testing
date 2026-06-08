package lesson_4;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private Color color;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.color = new Color (fillColor, borderColor);
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
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
