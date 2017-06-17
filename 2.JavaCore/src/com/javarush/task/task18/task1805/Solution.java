package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream stream = new FileInputStream(fileName);
        TreeSet<Integer> set = new TreeSet<>();

        while (stream.available() > 0) {
            set.add(stream.read());
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        for(Integer n : list) {
            System.out.print(n + " ");
        }
        reader.close();
        stream.close();
    }
}
