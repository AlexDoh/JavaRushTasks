package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> query_pairs = new LinkedHashMap<>();
        URL url = new URL(reader.readLine());
        String[] pairs = url.getQuery().split("&");
        for (String pair : pairs) {
            if (pair.contains("=")) {
                int idx = pair.indexOf('=');
                query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
            } else {
                query_pairs.put(pair, null);
            }
        }
        for (String key : query_pairs.keySet()) {
            System.out.print(key + ' ');
        }
        System.out.println();
        for (Map.Entry<String, String> mapPairs : query_pairs.entrySet()) {
            if(mapPairs.getKey().equals("obj")){
                try {
                    alert(Double.parseDouble(mapPairs.getValue()));
                } catch (NumberFormatException e){
                    alert(mapPairs.getValue());
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
