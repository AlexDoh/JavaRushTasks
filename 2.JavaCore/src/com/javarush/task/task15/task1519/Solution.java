package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            try {
                if (line.contains(".")) {
                    print(Double.parseDouble(line));
                } else if (Integer.parseInt(line) < 1 || Integer.parseInt(line) > 127) {
                    print(Integer.parseInt(line));
                } else {
                    print(Short.parseShort(line));
                }
            } catch (NumberFormatException e){
                print(line);
            }
//            if(line.matches("[.]\\d+")){
//                print(Double.parseDouble(line));
//            } else if(line.matches("\\d+") && Short.parseShort(line) > 0 && Short.parseShort(line) < 128){
//                print(Short.parseShort(line));
//            } else if(line.matches("\\d+") && (Integer.parseInt(line) < 0 || Integer.parseInt(line) >= 128)){
//                print(Integer.parseInt(line));
//            } else {
//                print(line);
//            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
