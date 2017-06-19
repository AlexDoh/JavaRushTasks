package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] strings = line.split(" ");
            if (strings[0].equals(args[0])) {
                System.out.println(strings[0] + ' ' + strings[1] + ' ' + strings[2] + ' ' + strings[3]);
                reader.close();
                break;
            }
        }
    }
}
