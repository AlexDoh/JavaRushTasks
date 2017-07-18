package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder line = new StringBuilder();
        for(Map.Entry<String, String> pair : params.entrySet()) {
            if(pair.getValue() != null) {
                if(line.length() > 0) line.append(" and ");
                line.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
            }
        }
        return line.toString();
    }
}
