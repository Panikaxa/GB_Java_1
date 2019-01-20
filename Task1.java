package ru.geekbrains.lesson3;

import java.util.Scanner;

public class Task1 {

    private static Scanner sc = new Scanner(System.in);

    private static boolean guess() {

        int hiddenNumber = (int) (Math.random() * 9);

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + "-я попытка. Введите ваше число.");
            int number = sc.nextInt();
            if (number > hiddenNumber) {
                System.out.println("Ваше число больше, чем загаданное");
            } else if (number < hiddenNumber) {
                System.out.println("Ваше число меньше, чем загаданное");
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int exit = 1;
        while (exit != 0) {
            System.out.println("Программа загадает число от 0 до 9." +
                    " У вас будет три попытки, чтобы отгадать это число. Удачи!");
            if (guess()) {
                System.out.println("Поздравляем, вы угадали!");
            } else {
                System.out.println("К сожалению вы проиграли.");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            exit = sc.nextInt();

        }
        sc.close();
    }
}
