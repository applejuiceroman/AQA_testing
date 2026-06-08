import lesson_7.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialZero() {
        assertEquals(1, FactorialCalculator.getFactorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, FactorialCalculator.getFactorial(1));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, FactorialCalculator.getFactorial(5));
    }

    @Test
    public void testFactorialSeven() {
        assertEquals(5040, FactorialCalculator.getFactorial(7));
    }

    @Test
    public void testFactorialNegative() {
        assertEquals(-1, FactorialCalculator.getFactorial(-5));
    }
}