package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);
        testString.printSomething();
        String fake = outputStream.toString();
        Integer answer = null;
        String[] arguments = fake.split(" ");
        if (arguments[1].equals("+")) {
            answer = Integer.parseInt(arguments[0]) + Integer.parseInt(arguments[2]);
        }
        if (arguments[1].equals("-")) {
            answer = Integer.parseInt(arguments[0]) - Integer.parseInt(arguments[2]);
        }
        if (arguments[1].equals("*")) {
            answer = Integer.parseInt(arguments[0]) * Integer.parseInt(arguments[2]);
        }


        fake += String.valueOf(answer);
        fake = fake.replace("\n", "").replace("\r", "");
        System.setOut(originalPrintStream);
        System.out.println(fake);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

