package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = inputReader.readLine();
        String file2 = inputReader.readLine();
        inputReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while (reader.ready()) {
            String line = reader.readLine();
            line = line.replaceAll("\\W", "");
            writer.write(line);
        }

        reader.close();
        writer.close();
    }
}
