package lesson_7;

public class NumberCompare {

    public static int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int getMax(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static int getMin(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    public static boolean isEquals(int a, int b) {
        return a == b;
    }
}
