package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream stream = new FileInputStream(fileName);

        int max = 0;

        while(stream.available() > 0) {
            int oneByte = stream.read();
            if(oneByte > max) {
                max = oneByte;
            }
        }
        System.out.println(max);
        reader.close();
        stream.close();
    }
}
