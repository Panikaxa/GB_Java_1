package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = SIZE - 0;
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
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект ");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        for (int i = 0; i <= SIZE-DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE-DOTS_TO_WIN; j++) {
                if (checkLines(symb, i, j) || checkDiag(symb, i, j)) return true;
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
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = symb;
                    if (checkWin(symb)) {
                        System.out.println("Компьютер походил в  " + (j + 1) + " " + (i + 1));
                        map[i][j] = DOT_O;
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    public static void aiTurn() {
        int x;
        int y;
        if (!checkCrit(DOT_O)) {
            if (!checkCrit(DOT_X)) {
                 do {
                     x = rand.nextInt(SIZE);
                     y = rand.nextInt(SIZE);
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

    public static boolean checkLines(char symb, int x, int y) {
        boolean cols, rows;
        for (int i = x; i < DOTS_TO_WIN+x; i++) {
            cols = true;
            rows = true;
            for (int j = y; j < DOTS_TO_WIN+y; j++) {
                cols = cols && (map[i][j] == symb);
                rows = rows && (map[j][i] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    public static boolean checkDiag(char symb, int x, int y) {
        boolean main, sec;

        for (int i = x; i < DOTS_TO_WIN+x; i++) {
            main = true;
            sec = true;
            for (int j = y; j < DOTS_TO_WIN+y; j++) {
                main = main && (map[j-y+x][j] == symb);
                sec = sec && (map[DOTS_TO_WIN+y+x-j-1][j] == symb);
            }
            if (main || sec) return true;
        }
        return false;
    }

    public static boolean checkWinOld(char symb) {
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
                str = (map[i][j] == symb) ? ++str : 0;
                row = (map[j][i] == symb) ? ++row : 0;
                mainDiag = (map[j][j] == symb) ? ++mainDiag : 0;
                if (i+j == SIZE-1) secDiag = (map[i][j] == symb) ? ++secDiag : 0;
                if (i+1 == j) overMainDiag = (map[i][j] == symb) ? ++overMainDiag : 0;
                if (j+1 == i) underMainDiag = (map[i][j] == symb) ? ++underMainDiag : 0;
                if (i+j == SIZE-2) overSecDiag = (map[i][j] == symb) ? ++overSecDiag : 0;
                if (i+j == SIZE) underSecDiag = (map[i][j] == symb) ? ++underSecDiag : 0;

                if (str == DOTS_TO_WIN || row == DOTS_TO_WIN || mainDiag == DOTS_TO_WIN ||
                        secDiag == DOTS_TO_WIN || overMainDiag == DOTS_TO_WIN ||
                        underMainDiag == DOTS_TO_WIN || overSecDiag == DOTS_TO_WIN ||
                        underSecDiag == DOTS_TO_WIN) {
                    return true;
                }
            }
            str = 0;
            row = 0;
        }
        return false;
    }
}