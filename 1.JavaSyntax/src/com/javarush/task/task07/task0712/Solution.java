package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i, j;

        for(i = 0;i < 10;i++){
            list.add(reader.readLine());
        }
        int min = list.indexOf(list.get(0));
        int minLength = list.get(0).length();
        int max = list.indexOf(list.get(0));
        int maxLength = list.get(0).length();

//        for(i = 0, j = 1;i < list.size() && j < list.size();i++,j++){
//
//        }
        for(String s : list){
            if(s.length() > maxLength){
                max = list.indexOf(s);
                maxLength = s.length();
            }
            if(s.length() < minLength){
                min = list.indexOf(s);
                minLength = s.length();
            }
        }
        if(max < min){
            System.out.print(list.get(max));
        } else
            System.out.print(list.get(min));
    }
}
