package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = inputReader.readLine();
        String file2 = inputReader.readLine();
        inputReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        ArrayList<Integer> list = new ArrayList<>();

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String s : words) {
                try {
                    list.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                }
            }
        }
        for(Integer n : list) {
            writer.write(String.valueOf(n));
            writer.write(' ');
        }

        //закрываем потоки после использования
        reader.close();
        writer.close();
    }
}
