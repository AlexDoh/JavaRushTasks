package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        String fileOut = bufRead.readLine();
        bufRead.close();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader readIn = new BufferedReader(new FileReader(fileOut));
        String str;
        final Pattern pattern = Pattern.compile("^\\d+");
        Matcher matcher;
        long maxNum = 0;
        while (readIn.ready()) {
            str = readIn.readLine();
            list.add(str);
            matcher = pattern.matcher(str);
            long num = 0;
            while (matcher.find()) {
                num = Long.parseLong(matcher.group(0));
            }
            if (num > maxNum) {
                maxNum = num;
            }
        }
        readIn.close();
        if (args[0].equals("-c")) {
            list.add(String.format("%-8d%-30s%-8s%-4s", (++maxNum), args[1], args[2], args[3]));
        }

        BufferedWriter bufWrite = new BufferedWriter(new FileWriter(fileOut));
        for (String s : list){
            bufWrite.write(s+"\n");
        }
        bufWrite.close();
    }
}

/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        String idLine = "";
        while (true) {
            line = reader.readLine();
            if (line == null) {
                break;
            } else {
                idLine = line;
            }
        }
        System.out.println(idLine);
        Pattern pattern = Pattern.compile("^\\d+");
        Matcher matcher = pattern.matcher(idLine);
        matcher.find();

        Integer id = Integer.parseInt(matcher.group(0));
        id++;

        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        fileOutputStream.write(id.toString().getBytes());

        if (matcher.group(0).length() < 8) {
            fileOutputStream.write(matcher.group(0).getBytes());
            fileOutputStream.write(32);
        } else {
            fileOutputStream.write(matcher.group(0).getBytes());
        }

        if (args[1].length() < 30) {
            fileOutputStream.write(args[1].getBytes());
            fileOutputStream.write(32);
        } else {
            fileOutputStream.write(args[1].getBytes());
        }

        if (args[2].length() < 8) {
            fileOutputStream.write(args[2].getBytes());
            fileOutputStream.write(32);
        } else {
            fileOutputStream.write(args[2].getBytes());
        }

        if (args[3].length() < 4) {
            fileOutputStream.write(args[3].getBytes());
            fileOutputStream.write(32);
        } else {
            fileOutputStream.write(args[3].getBytes());
        }*/
