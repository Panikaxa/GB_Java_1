package ru.geekbrains.lesson3;

import java.util.Scanner;

public class Task2 {
    private static Scanner sc = new Scanner(System.in);
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static char[] hintArray = {'#', '#', '#', '#', '#', '#', '#', '#', '#',
            '#', '#', '#', '#', '#', '#'};

    public static void main(String[] args) {
        int randomIndex = (int) (Math.random() * words.length);
        String hiddenWords = words[randomIndex];
//        System.out.println(hiddenWords);
        System.out.println("The program makes a fruit or vegetable. You have to guess it!");

        while (true) {
            System.out.println("Enter your answer:");
            String answer = sc.next().toLowerCase();
            if (!answer.equals(hiddenWords)) {
                int length;
                if (answer.length() < hiddenWords.length()) {
                    length = answer.length();
                } else {
                    length = hiddenWords.length();
                }

                for (int i = 0; i < length; i++) {
                    if (hiddenWords.charAt(i) == answer.charAt(i)) {
                        for (int j = 0; j < hintArray.length; j++) {
                            hintArray[i] = hiddenWords.charAt(i);
                        }
                    }
                }
                for (char ch : hintArray) System.out.print(ch);
                System.out.println();
            } else {
                System.out.println("Congratulations! You guessed! The hidden word is " + hiddenWords + " !");
                break;
            }
        }
        sc.close();
    }
}