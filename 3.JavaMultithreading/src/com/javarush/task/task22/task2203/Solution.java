package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) throw new TooShortStringException();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\t') {
                count++;
            }
        }
        if(count < 2) throw new TooShortStringException();
        else {
            return string.substring(string.indexOf("\t") + 1, string.indexOf("\t", string.indexOf("\t") + 1));
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
