import lesson_7.NumberCompare;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberCompareTest {
    @Test
    public void testCompareFirstGreater() {
        assertEquals(1, NumberCompare.compare(10, 5));
        assertEquals(1, NumberCompare.compare(0, -1));
    }

    @Test
    public void testCompareFirstLess() {
        assertEquals(-1, NumberCompare.compare(5, 10));
        assertEquals(-1, NumberCompare.compare(-5, 0));
    }

    @Test
    public void testCompareEqual() {
        assertEquals(0, NumberCompare.compare(5, 5));
        assertEquals(0, NumberCompare.compare(-10, -10));
    }

    @Test
    public void testGetMax() {
        assertEquals(10, NumberCompare.getMax(5, 10));
        assertEquals(5, NumberCompare.getMax(5, 3));
        assertEquals(-5, NumberCompare.getMax(-10, -5));
    }

    @Test
    public void testGetMin() {
        assertEquals(5, NumberCompare.getMin(5, 10));
        assertEquals(3, NumberCompare.getMin(5, 3));
        assertEquals(-10, NumberCompare.getMin(-10, -5));
    }

    @Test
    public void testIsEquals() {
        assertTrue(NumberCompare.isEquals(5, 5));
        assertFalse(NumberCompare.isEquals(5, 6));
    }
}
