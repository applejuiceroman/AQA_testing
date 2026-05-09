package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(sumInRange(2, 7));
        System.out.println(returnBool(-232));
        printMultipleStrings("Несколько строк", 4);
        System.out.println(isYearLeap(100));
        arrayInversion();
        arrayFilling();
        multiplyByTwo();
        squareArray();
        int[] array1 = createArray(9, 10);
        System.out.println(Arrays.toString(array1));

    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple\n");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -55;
        if (a + b >= 0) {
            System.out.println("Сумма положительная\n");
        } else {
            System.out.println("Сумма отрицательная\n");
        }
    }

    public static void printColor() {
        int a = 255;
        if (a <= 0) {
            System.out.println("Красный\n");
        } else if (a <= 100) {
            System.out.println("Жёлтый\n");
        } else {
            System.out.println("Зелёный\n");
        }
    }

    public static void compareNumbers() {
        int a = 14;
        int b = 20;
        if (a >= b) {
            System.out.println("a >= b\n");
        } else {
            System.out.println("a < b\n");
        }
    }

    public static boolean sumInRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean returnBool(int digit) {
        System.out.println("\n");
        return digit < 0;
    }

    public static void printMultipleStrings(String str, int count) {
        System.out.println("\n");
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
        System.out.println("\n");
    }

    public static boolean isYearLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void arrayInversion() {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("\nМассив после замены:" + Arrays.toString(arr) + "\n");
    }

    public static void arrayFilling() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    public static void multiplyByTwo() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println("Массив после умножения элементов на 2:" + Arrays.toString(arr) + "\n");
    }

    public static void squareArray() {
        int size = 7;
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][i] = 1;
                System.out.printf("%4d ", table[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) {
        System.out.println("\n");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}