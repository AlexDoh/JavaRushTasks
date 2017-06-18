package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Character> set = new ArrayList<>();
        int c;
        while((c = fileInputStream.read()) != -1) {
            Character character = Character.valueOf((char)c);
            if(alphabet.contains(character.toString())) {
                set.add(character);
            }
        }

        System.out.println(set.size());
        fileInputStream.close();
    }
}
