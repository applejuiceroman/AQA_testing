import lesson_7.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ArithmeticOperationsTest {
    @Test
    public void testAdd() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
        assertEquals(0, ArithmeticOperations.add(-2, 2));
        assertEquals(-5, ArithmeticOperations.add(-2, -3));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, ArithmeticOperations.subtract(2, 3));
        assertEquals(5, ArithmeticOperations.subtract(10, 5));
        assertEquals(0, ArithmeticOperations.subtract(7, 7));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, ArithmeticOperations.divide(5, 2));
        assertEquals(0.0, ArithmeticOperations.divide(0, 5));
        assertEquals(0.0, ArithmeticOperations.divide(10, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
        assertEquals(0, ArithmeticOperations.multiply(5, 0));
        assertEquals(-6, ArithmeticOperations.multiply(-2, 3));
    }
}
