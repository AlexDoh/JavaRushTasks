package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream stream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<>();

        while (stream.available() > 0) {
            int oneByte = stream.read();
            if(oneByte == 44) {
                list.add(oneByte);
            }
        }
        System.out.println(list.size());
        reader.close();
        stream.close();
    }
}
