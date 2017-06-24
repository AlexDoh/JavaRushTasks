package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while(reader.ready()) {
            String line = reader.readLine();
            String[] parts = line.split(" ");
            if(map.containsKey(parts[0])) {
                map.put(parts[0], map.get(parts[0]) + Double.parseDouble(parts[1]));
            } else {
                map.put(parts[0], Double.parseDouble(parts[1]));
            }
        }
        reader.close();
        for(Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + ' ' + pair.getValue());
        }
    }
}
