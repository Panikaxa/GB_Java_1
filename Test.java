package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = SIZE - 1;
    public static final char DOT_EMPTY = '\u258B';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map = { {'▋', '▋', '▋', '▋', '▋'},
                                   {'▋', '▋', '▋', 'O', '▋'},
                                   {'▋', '▋', 'O', '▋', '▋'},
                                   {'▋', 'O', '▋', '▋', '▋'},
                                   {'O', '▋', '▋', '▋', '▋'}
                                 };
    public static char[][] temp;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

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

        if (checkWin(DOT_O)) {
            System.out.println("Победил Искуственный Интеллект");
        } else {
            System.out.println("Победил никто");
        }

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

    public static boolean checkWin(char symb) {
        for (int i = 0; i <= SIZE-DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE-DOTS_TO_WIN; j++) {
                if (checkLines(symb, i, j) || checkDiag(symb, i, j)) return true;
            }
        }
        return false;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void print() {
        for (int i = 0; i <= SIZE-DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE-DOTS_TO_WIN; j++) {
                printVert(i, j);
            }
        }
    }

    public static void printVert(int x, int y) {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = x; i < DOTS_TO_WIN+x; i++) {
            System.out.print((i + 1) + " ");
            for (int j = y; j < DOTS_TO_WIN+y; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
