package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFile1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter readerFile2 = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();

        while (readerFile1.ready()) {
            String line = readerFile1.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 6) {
                    stringBuilder.append(word).append(',');
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        readerFile2.write(stringBuilder.toString());
        readerFile1.close();
        readerFile2.close();
    }
}
