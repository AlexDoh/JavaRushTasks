package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int size = fileInputStream.available();
        int count = 0;
        while (fileInputStream.available() > 0) {
            int oneChar = fileInputStream.read();
            if (oneChar == 32) {
                count++;
            }
        }
//        System.out.println((float) count / (float)size * 100);
        DecimalFormat format = new DecimalFormat("#.00");
        System.out.println(format.format(count * 1.0 / size * 100));
        fileInputStream.close();
    }
}
