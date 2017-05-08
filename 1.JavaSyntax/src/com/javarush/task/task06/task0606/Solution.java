package com.javarush.task.task06.task0606;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();

        for(int i = 0;i < number.length();i++){
            if((int)number.charAt(i) % 2 == 0){
                even++;
            } else
                odd++;
        }
        System.out.print("Even: " + even + " Odd: " + odd);
    }
}
