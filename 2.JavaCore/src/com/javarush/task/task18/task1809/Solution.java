package com.javarush.task.task18.task1809;

/* 
Реверс файла
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

        FileInputStream stream1 = new FileInputStream(fileName1);
        FileOutputStream stream2 = new FileOutputStream(fileName2);

        byte[] buffer = new byte[stream1.available()];
        stream1.read(buffer);
        byte[] reversedBuffer = new byte[buffer.length];
        for (int i = 0; i < reversedBuffer.length; i++) {
            reversedBuffer[i] = buffer[buffer.length - i - 1];
        }
        stream2.write(reversedBuffer);
        reader.close();
        stream1.close();
        stream2.close();
    }
}
