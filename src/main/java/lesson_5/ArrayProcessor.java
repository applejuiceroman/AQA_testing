package lesson_5;

public class ArrayProcessor {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("В массиве должно быть 4 строки. Количество строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("В строке " + i + " должно быть 4 столбца. Количество столбцов: " + array[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }

    public static void demoArrayIndexOutOfBounds() {
        System.out.println("\n-----ArrayIndexOutOfBoundsException-----");

        try {
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Попытка доступа к элементу под индексом 7..");
            int value = numbers[7];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
            System.out.println(e.getMessage());
        }

        try {
            String[][] array = new String[3][3];
            System.out.println("\nПопытка доступа к массиву 5х5...");
            array[5][5] = "test";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
            System.out.println(e.getMessage());
        }

        try {
            int[] array = new int[10];
            System.out.println("\nПопытка доступа к индексу -1...");
            array[-1] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
            System.out.println(e.getMessage());
        }
    }
}
