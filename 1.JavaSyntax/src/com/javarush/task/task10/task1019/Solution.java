package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();

        while (true) {

            String id = reader.readLine();
            String name = reader.readLine();

            if (id.isEmpty()) {
                break;
            }


            map.put(name, id);
        }
        for (HashMap.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }

    }
}