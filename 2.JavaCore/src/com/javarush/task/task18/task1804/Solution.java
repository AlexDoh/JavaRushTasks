package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream stream = new FileInputStream(fileName);
        HashMap<Integer, Integer> map = new HashMap<>();

        while (stream.available() > 0) {
            int element = stream.read();
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
        reader.close();
        stream.close();
        if(map.isEmpty()) {
            return;
        } else {
            int min = Collections.min(map.values());
            for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if(pair.getValue().equals(min)) {
                    System.out.print(pair.getKey() + " ");
                }
            }
        }
    }
}
