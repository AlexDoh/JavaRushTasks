package com.javarush.task.task22.task2202;

import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string == null) throw new TooShortStringException();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                count++;
            }
        }
        if (count < 4) throw new TooShortStringException();
        else {
            String[] parts = string.split(" ");
            StringBuilder stringBuilder = new StringBuilder(parts[1]).append(' ');
            for (int i = 2; i < 5; i++) {
                stringBuilder.append(parts[i]).append(' ');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
