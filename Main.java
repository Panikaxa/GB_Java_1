package ru.geekbrains.lesson1;


public class Main {

    // Task1 - Создал метод main()
    public static void main(String[] args) {

        // Task2 - создал переменные всех типов и инициализировал их
        byte a = 15;
        short b  = 32750;
        int c = -2147483600;
        long d = 2548975456456754545L;
        float e = 547.56f;
        double f = 547.56;
        boolean g = true;
        char h = 'H';

        // Вызов метода из task3
        System.out.println(calc(3, 4, 6, 2));
        // Вызов метода из task4
        System.out.println(checkSum(10, 10));
        // Вызов метода из task5
        checkSign(-5);
        // Вызов метода из task6
        System.out.println(checkSign2(0));
        // Вызов метода из task7
        hello("Евгений");
        // Вызов метода из task8
        checkYear(2020);
    }

    // Task3 - метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат;
    public static int calc(int a, int b, int c, int d) {
        return a * (b + c / d);
    }

    // Task4 - метод, проверяющий что сумма двух чисел лежит в пределах от 10 до 20(включительно);
    public static boolean checkSum(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    //Task5 - метод, определяющий положительное или отрицательное число было передано;
    public static void checkSign(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //Task6 - метод, возвращающий true, если число отрицательное;
    public static boolean checkSign2(int a){
        return (a < 0);
    }

    //Task7 - метод приветствия;
    public static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //Task8 - метод, определяющий високосный год;
    public static void checkYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " год - високосный.");
        } else {
            System.out.println(year + " год - не високосный.");
        }
    }

}
