package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (stream.available() > 0) {
            int element = stream.read();
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
        stream.close();
        if (map.isEmpty()) {
            return;
        } else {
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                System.out.println((char)pair.getKey().intValue() + " " + pair.getValue());
            }
        }
    }
}
