package lesson_5;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----Массив 4x4-----\n");

        System.out.println("На вводе массив размером 4х4, во всех ячейках верные данные");
        String[][] correctSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = ArrayProcessor.processArray(correctSizeArray);
            System.out.println("Сумма всех элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n" + "====================" + "\n");

        System.out.println("На вводе массив с неправильным количеством строк");
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"17", "18", "19", "20"}
        };

        try {
            int sum = ArrayProcessor.processArray(wrongSizeArray);
            System.out.println("Сумма всех элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано исключение MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\n" + "====================" + "\n");

        System.out.println("На вводе массив с неправильным количеством столбцов");
        String[][] wrongColumnsArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };

        try {
            int sum = ArrayProcessor.processArray(wrongColumnsArray);
            System.out.println("Сумма всех элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано исключение MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\n" + "====================" + "\n");

        System.out.println("На вводе массив размером 4х4, в некоторых ячейках неверные данные");
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "пятнадцать", "16"}
        };

        try {
            int sum = ArrayProcessor.processArray(invalidDataArray);
            System.out.println("Сумма всех элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано исключение MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\n" + "====================" + "\n");

        System.out.println("На вводе массив размером 4х4, в некоторых ячейках нет данных");
        String[][] emptyCellArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", ""}
        };

        try {
            int sum = ArrayProcessor.processArray(emptyCellArray);
            System.out.println("Сумма всех элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано исключение MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано исключение MyArrayDataException: " + e.getMessage());
        }

        ArrayProcessor.demoArrayIndexOutOfBounds();
    }
}
