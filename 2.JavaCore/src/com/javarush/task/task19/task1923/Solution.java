package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFile1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter readerFile2 = new BufferedWriter(new FileWriter(args[1]));

        while(readerFile1.ready()) {
            String line = readerFile1.readLine();
            String[] words = line.split(" ");
            for(String word : words) {
                if(word.matches(".*\\d+.*")) {
                    readerFile2.write(word);
                    readerFile2.write(' ');
                }
            }
        }
        readerFile1.close();
        readerFile2.close();
    }
}
