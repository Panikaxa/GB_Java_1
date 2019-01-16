package ru.geekbrains.lesson2;

import static java.lang.Math.abs;

public class Lesson2 {
    //Заполнение массива рандомными числами;
    private static void fillRandomArray(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * k);
        }
    }
    //Вывод на экран массива
    private static void outputArray (int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Task1 - метод, заменяющий в заданном массиве 0 на 1 и 1 на 0;
    private static void oneZeroZeroOne() {
        int[] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив:");
        outputArray(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }
        System.out.println("Преобразованный массив:");
        outputArray(arr);
    }
    // Task2 - метод, заполняющий массив значениями  0 3 6 9 12 15 18 21;
    private static void fillArrayPlusThree() {
        int[] arr = new int[8];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = j;
            j = j + 3;
        }
        outputArray(arr);
    }
    // Task3 - метод, умножающий на 2 числа в массиве, меньшие 6;
    private static void mulByTwo() {
        int[] arr = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив:");
        outputArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println("Преобразованный массив:");
        outputArray(arr);
    }
    // Task4 - метод, заполняющий диагонали квадратного двумерного массива 1;
    private static void fillDiagonalArray(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i+j == arr.length-1) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    // Task5 - метод, определяющий минимальный и максимальный элемент в массиве;
    private static void minMaxElementOfArray(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        System.out.println("Максимальный элемент: " + max + "\n" +
                "Минимальный элемент " + min);
    }
    // Task6 - метод возвращает true, если в массиве есть место, в котором сумма
    // левой части равна сумме правой части;
    private static boolean checkBalance(int[] arr){
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 = sum1 + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum2 = sum2 + arr[j];
            }
            if (sum1 == sum2) {
                return true;
            }
            sum2 = 0;
        }
        return false;
    }
    // Task7 - метод смещает элементы в массиве на заданное число позиций влево или вправо
    private static void shiftArray(int[] a, int bias) {
        if (bias < 0) {
            for (int j = 1; j <= abs(bias); j++) {
                int store = a[0];
                for (int i = 0; i < a.length - 1; i++) {
                    a[i] = a[i + 1];
                }
                a[a.length - 1] = store;
            }
        } else {
            for (int j = 1; j <= abs(bias); j++) {
                int store = a[a.length-1];
                for (int i = a.length-1; i > 0; i--) {
                    a[i] = a[i-1];
                }
                a[0] = store;
            }
        }
    }

    public static void main(String[] args) {
        // Task1;
        System.out.println("Task 1. Заменить в заданном массиве 0 на 1 и 1 на 0");
        oneZeroZeroOne();

        // Task2;
        System.out.println("Task 2. Заполнить массив значениями  0 3 6 9 12 15 18 21");
        fillArrayPlusThree();

        // Task3;
        System.out.println("Task 3. Умножить на 2 числа в заданном массиве, меньшие 6");
        mulByTwo();

        // Task4;
        System.out.println("Task 4. Заполнить диагонали квадратного двумерного массива 1");
        fillDiagonalArray(4); //n - размерность двумерного квадратного массива;

        // Task5;
        System.out.println("Task 5. Определить минимальный и максимальный элемент в массиве");
        int n = 10; //размерность массива;
        int[] arr = new int[n];
        fillRandomArray(arr, 100); //k - верхняя граница рандомайзера;
        outputArray(arr);
        minMaxElementOfArray(arr);

        //Task6;
        System.out.println("Task 6. Вернуть true, если в массиве есть место, в котором " +
                "сумма левой части равна сумме правой части");
        int m = 6; //размерность массива;
        int[] array = new int[m];
        fillRandomArray(array, 5); //k - верхняя граница рандомайзера;
        outputArray(array);
        System.out.println(checkBalance(array));

        //Task7;
        System.out.println("Task 7. Сместить все элементы массива на заданное число позиций");
        int[] a = {0, 1, 2, 3, 4, 5};
        int bias = -1; // число позиций для смещения;
        System.out.println("Исходный массив:");
        outputArray(a);
        shiftArray(a, bias);
        System.out.println("Преобразованный массив со смещением элементов на " + bias);
        outputArray(a);
    }
}
