package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String file = inputReader.readLine();
        inputReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int countWords = 0;
        while (reader.ready())
        {
            String line = reader.readLine();
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher = pattern.matcher(line);

            while(matcher.find()) {
                countWords++;
            }
        }
        reader.close();
        System.out.println(countWords);
    }
}
