package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName1);
        InputStream inputStream1 = new FileInputStream(fileName2);
        OutputStream outputStream = new FileOutputStream(fileName1, true);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        byte[] buffer1 = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        outputStream.write(buffer1);
        outputStream.write(buffer);
        reader.close();
        outputStream.close();
        inputStream.close();
        inputStream1.close();
    }
}
