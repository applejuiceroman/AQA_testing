package lesson_7;

public class FactorialCalculator {

    public static long getFactorial(int number) {
        long result = 1;

        if (number == 0) {
            return 1;
        }

        if (number < 0) {
            return -1;
        }

        for (int i = 1; i <= number; i++) {
            result = result * i;
        }

        return result;
    }
}
