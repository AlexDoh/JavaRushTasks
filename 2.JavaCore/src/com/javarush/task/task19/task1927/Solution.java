package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream originalPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream myPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(myPrintStream);

        testString.printSomething();
        String[] strings = byteArrayOutputStream.toString().split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++){
            if ((i % 2 == 0 && i != 0))
                stringBuilder.append("JavaRush - курсы Java онлайн").append("\n");
            stringBuilder.append(strings[i]).append("\n");
        }


//        byteArrayOutputStream.toString().re
//        byte[] arr = byteArrayOutputStream.toByteArray();
//        for(int i = 0; i < arr.length;i++) {
//            byteArrayOutputStream.toByteArray()
//        }

        System.setOut(originalPrintStream);
        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
