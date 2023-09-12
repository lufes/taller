package com.uco.taller.letterRemover;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input a word:");
        String word = scan.nextLine();

        StringBuilder newWord = new StringBuilder();
        int index = 0;

        while (index < word.length())   {
            if ((index + 1) % 3 != 0)  {
                newWord.append(word.charAt(index));
            }
            index++;
        }

        System.out.println(newWord);
    }
}
