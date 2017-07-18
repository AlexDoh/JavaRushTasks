package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));
        StringBuilder result = getLine(reader.readLine().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();
        Arrays.sort(words);
        StringBuilder result = new StringBuilder(words[0]);
        for (int j = 1; j < words.length; j++) {
            for (int i = 1; i < words.length; i++) {
                if (result.toString().toLowerCase().charAt(result.length() - 1) == words[i].toLowerCase().charAt(0)) {
                    result.append(" ").append(words[i]);
                    words[i] = " ";
                    break;
                }
            }
        }
        words[0] = " ";
        for (String s : words) {
            if (!s.equals(" ")) {
                result.append(" ").append(s);
            }
        }
        return result;
    }
}
