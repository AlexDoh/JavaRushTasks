package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        String fileName = reader.nextLine();

        FileInputStream stream = new FileInputStream(fileName);

        int min = stream.read();

        while (stream.available() > 0) {
            int oneByte = stream.read();
            if (oneByte < min) {
                min = oneByte;
            }
        }
        System.out.println(min);
        reader.close();
        stream.close();
    }
}
