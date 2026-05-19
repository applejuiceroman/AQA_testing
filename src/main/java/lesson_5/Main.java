package lesson_5;

public class Main {
    public static void main (String[] args) {
        int a;
        int array[] = new int[3];
        try {
            a = array[3];
            a = 0;
        }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException");
            }
        }
    }
