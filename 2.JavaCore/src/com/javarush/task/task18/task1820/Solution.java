package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName1);
        OutputStream outputStream = new FileOutputStream(fileName2);
        StringBuilder digit = new StringBuilder();

        while (inputStream.available() > 0) {
            int oneChar = inputStream.read();
            if (oneChar != 32) {
                digit.append((char) oneChar);
            } else {
                Long rounded = Math.round(Double.parseDouble(digit.toString()));
                outputStream.write(rounded.toString().trim().getBytes());
                outputStream.write(32);
                digit.setLength(0);
            }
        }
        outputStream.write(digit.toString().getBytes());

        reader.close();
        outputStream.close();
        inputStream.close();
    }
}

    /*byte[] bt = new byte[fis.available()];
fis.read(bt);
        fis.close();
        String[] numbers = new String(bt).split(" ");
        String line = "";

        for (String s : numbers){
        line += Math.round(Double.parseDouble(s)) + " ";
        }
        fos.write(line.trim().getBytes());
        fos.close();*/