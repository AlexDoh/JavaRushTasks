package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        //напишите тут ваш код
        a = sc.nextInt();
        System.out.print((int)Math.pow(a, 2));
    }
}