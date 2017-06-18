package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        OutputStream outputStream = new FileOutputStream(fileName1, true);
        InputStream inputStream = new FileInputStream(fileName2);
        InputStream inputStream1 = new FileInputStream(fileName3);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        outputStream.write(buffer);
        byte[] buffer1 = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        outputStream.write(buffer1);
        reader.close();
        outputStream.close();
        inputStream.close();
        inputStream1.close();
    }
}
