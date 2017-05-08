package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends IOException {
    }

    static class MyException2 extends NoSuchFieldException {
    }

    static class MyException3 extends ArrayIndexOutOfBoundsException {
    }

    static class MyException4 extends IndexOutOfBoundsException {
    }
}

