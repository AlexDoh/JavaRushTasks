package com.javarush.task.task14.task1419;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            FileReader reader = new FileReader("lolo");

        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            String[] arr = new String[]{};
            String line = arr[0];

        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            List<String> arr = new ArrayList<>();
            arr.get(0);

        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new IOException();

        } catch (IOException e) {
            exceptions.add(e);
        }

        try {
            List<String> list = new ArrayList<>();

            LinkedList<String> list2 = (LinkedList<String>) list;

        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            throw new SQLException();

        } catch (SQLException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalArgumentException();

        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }
        try {
            Solution s = null;
            System.out.println(s.toString());

        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            throw new RuntimeException();

        } catch (RuntimeException e) {
            exceptions.add(e);
        }

    }
}
