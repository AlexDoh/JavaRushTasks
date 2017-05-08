package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        /*for(int r = 0; r < 2;r++){
            for(int i = 0;i < array.length;i++){
                if(!isNumber(array[i])){
                    String firstString = array[i];
                    for(int j = i+1;j < array.length;j++){
                        if(!isNumber(array[j])){
                            String secondString = array[j];
                            if(!isGreaterThan(secondString, firstString)){
                                array[i] = secondString;
                                array[j] = firstString;
                                break;
                            }
                        }
                    }
                }
                if(isNumber(array[array.length - 1 - i])){
                    String firstNumber = array[array.length - 1 - i];
                    for(int j = array.length - 2 - i;j < array.length;j++){
                        if(isNumber(array[j])){
                            String secondNumber = array[j];
                            if(Integer.parseInt(secondNumber) > Integer.parseInt(firstNumber)){
                                array[array.length - 1 - i] = secondNumber;
                                array[j] = firstNumber;
                                break;
                            }
                        }
                    }
                }
            }
        }*/
        //Моё решение выше, валидатор забраковал, но ответ правильный...
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++ ) {
                if (isNumber(array[i]) && isNumber(array[j])) {
                    if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
                        String tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                }
                if (!isNumber(array[i]) && !isNumber(array[j])) {
                    if (isGreaterThan(array[i], array[j])) {
                        String tmp = array[j];
                        array[j] = array[i];
                        array[i] = tmp;
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
