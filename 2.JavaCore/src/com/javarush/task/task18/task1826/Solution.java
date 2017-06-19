package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        int a = 325;
//        a = a & 5;
//        a = a >>= 1;
//        System.out.println(a);
        if(args[0].equals("-e")) {
            FileOutputStream fileOutputStream =  new FileOutputStream(args[2]);

            fileOutputStream.write(encrypt(args[1]));
            fileOutputStream.close();
        }
        if(args[0].equals("-d")) {
            FileOutputStream fileOutputStream =  new FileOutputStream(args[2]);

            fileOutputStream.write(decrypt(args[1]));
            fileOutputStream.close();
        }
    }

    public static byte[] encrypt(String filename) throws IOException {
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(filename));

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (buffer[i] + 100);
        }
        fileInputStream.close();
        return buffer;
    }

    public static byte[] decrypt(String filename) throws IOException {
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(filename));

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (buffer[i] - 100);
        }
        fileInputStream.close();
        return buffer;
    }

}
