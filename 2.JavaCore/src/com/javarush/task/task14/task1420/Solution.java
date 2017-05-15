package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer a = Integer.parseInt(reader.readLine());
        Integer b = Integer.parseInt(reader.readLine());

            if(a <= 0 || b <= 0){
                throw new NumberFormatException();
            }

            while (b > 0) {
                int tempValue = b;
                b = a % b;
                a = tempValue;
            }

            System.out.println(a);

    }
}