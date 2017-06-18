package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream stream = new FileInputStream(fileName1);
        FileOutputStream stream1 = new FileOutputStream(fileName2);
        FileOutputStream stream2 = new FileOutputStream(fileName3);

        byte[] buffer1 = new byte[stream.available() / 2 + stream.available() % 2];
        stream.read(buffer1);
        stream1.write(buffer1);
        byte[] buffer2 = new byte[stream.available()];
        stream.read(buffer2);
        stream2.write(buffer2);
        reader.close();
        stream.close();
        stream1.close();
        stream2.close();
    }
}
