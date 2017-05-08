package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int even = 0, odd = 0;
        int i, j;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[15];

        for(i = 0;i < arr.length;i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        for(i = 0, j = 1;i < arr.length && j < arr.length;i+=2,j+=2){
            even += arr[i];
            odd += arr[j];
        }
        if(odd > even){
            System.out.print("В домах с нечетными номерами проживает больше жителей.");
        }
        if(even > odd){
            System.out.print("В домах с четными номерами проживает больше жителей.");
        }
    }
}
