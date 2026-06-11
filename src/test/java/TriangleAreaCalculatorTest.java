import lesson_7.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {
    @Test
    public void testValidTriangle() {
        double area = TriangleAreaCalculator.getAreaByThreeSides(3, 4, 5);
        assertEquals(6.0, area, 0.001);
    }

    @Test
    public void testInvalidTriangle() {
        double area = TriangleAreaCalculator.getAreaByThreeSides(1, 1, 3);
        assertEquals(-1, area);
    }

    @Test
    public void testEquilateralTriangle() {
        double area = TriangleAreaCalculator.getAreaByThreeSides(2, 2, 2);
        double expected = Math.sqrt(3);
        assertEquals(expected, area, 0.001);
    }

    @Test
    public void testAreaByBaseAndHeight() {
        double area = TriangleAreaCalculator.getAreaByBaseAndHeight(5, 4);
        assertEquals(10.0, area, 0.001);
    }


    @Test
    public void testNegativeBase() {
        double area = TriangleAreaCalculator.getAreaByBaseAndHeight(-5, 4);
        assertEquals(-1, area);
    }
}
