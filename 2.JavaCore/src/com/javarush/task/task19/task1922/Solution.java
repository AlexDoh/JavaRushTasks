package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerInput = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerInput.readLine();
        readerInput.close();

        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

        while(readerFile.ready()) {
            String line = readerFile.readLine();
            int count = 0;
            for(String s : words) {
                if(line.contains(s)) {
                    count++;
                }
            }
            if(count == 2) {
                System.out.println(line);
            }
            count = 0;
        }
        readerFile.close();
    }
}
