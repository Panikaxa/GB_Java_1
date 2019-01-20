package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = SIZE - 1;
    public static final char DOT_EMPTY = '\u258B';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static char[][] temp;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, map)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O, map)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb, char[][] mass) {
        int str = 0;
        int row = 0;
        int mainDiag = 0;
        int secDiag = 0;
        int overMainDiag = 0;
        int underMainDiag = 0;
        int overSecDiag = 0;
        int underSecDiag = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                str = (mass[i][j] == symb) ? ++str : 0;
                row = (mass[j][i] == symb) ? ++row : 0;
                mainDiag = (mass[j][j] == symb) ? ++mainDiag : 0;
                if (i+j == SIZE-1) secDiag = (mass[i][j] == symb) ? ++secDiag : 0;
                if (i+1 == j) overMainDiag = (mass[i][j] == symb) ? ++overMainDiag : 0;
                if (j+1 == i) underMainDiag = (mass[i][j] == symb) ? ++underMainDiag : 0;
                if (i+j == SIZE-2) overSecDiag = (mass[i][j] == symb) ? ++overSecDiag : 0;
                if (i+j == SIZE) underSecDiag = (mass[i][j] == symb) ? ++underSecDiag : 0;

                if (str == DOTS_TO_WIN || row == DOTS_TO_WIN || mainDiag == DOTS_TO_WIN ||
                        secDiag == DOTS_TO_WIN || overMainDiag == DOTS_TO_WIN ||
                        underMainDiag == DOTS_TO_WIN || overSecDiag == DOTS_TO_WIN ||
                        underSecDiag == DOTS_TO_WIN) {
                            return true;
                }
            }
        }
        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkCrit(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                temp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (temp[i][j] == DOT_EMPTY) {
                    temp[i][j] = symb;
                    if (checkWin(symb, temp)) {
                        System.out.println("Компьютер походил в  " + (j + 1) + " " + (i + 1));
                        map[i][j] = DOT_O;
                        return true;
                    }
                }
                temp[i][j] = map[i][j];
            }
        }
        return false;
    }

    public static void aiTurn() {
        int x = rand.nextInt(SIZE);
        int y = rand.nextInt(SIZE);
        if (!checkCrit(DOT_O)) {
            if (!checkCrit(DOT_X)) {
                M: do {
                    for (int i = 0; i < SIZE; i++) {
                        for (int j = 0; j < SIZE; j++) {
                            if (map[i][j] == DOT_O) {
                                if (j == SIZE-1) {
                                    x = j + 1;
                                    y = i;
                                    break M;
                                } else {
                                    x = j;
                                    y = i+1;
                                    break M;
                                }
                            }
                        }
                    }
                } while (!isCellValid(x, y));
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        temp = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
                temp[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
