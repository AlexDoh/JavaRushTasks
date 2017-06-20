package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        String fileOut = bufRead.readLine();
        bufRead.close();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader readIn = new BufferedReader(new FileReader(fileOut));
        String str;
        while (readIn.ready()) {
            str = readIn.readLine();
            list.add(str);
        }
        readIn.close();
        if (args[0].equals("-u")) {
            for (String s : list) {
                final Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find() && matcher.group(0).equals(args[1])) {
                    list.set(list.indexOf(s), String.format("%-8s%-30s%-8s%-4s", matcher.group(0), args[2], args[3], args[4]));
                    break;
                }
            }
        }

        if (args[0].equals("-d")) {
            for (String s : list) {
                final Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(s);
                matcher.find();
                if (matcher.group(0).equals(args[1])) {
                    list.remove(list.indexOf(s));
                }
            }
        }

        BufferedWriter bufWrite = new BufferedWriter(new FileWriter(fileOut));
        for (String s : list) {
            System.out.println(s);
            bufWrite.write(s + "\n");
        }
        bufWrite.close();
    }
}
