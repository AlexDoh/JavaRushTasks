package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        StringBuilder tags = new StringBuilder();
        while (reader.ready()) {
            tags.append(reader.readLine());
        }
        reader.close();

        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        int index = 0;
        while (true) {
            index = tags.indexOf("<" + args[0], index);
            if (index == -1) break;
            start.add(index);
            index++;
        }

        index = 0;
        while (true) {
            index = tags.indexOf("/" + args[0], index);
            if (index == -1) break;
            end.add(index);
            index++;
        }
        System.out.println();


        while (!start.isEmpty()) {
            int n = 0;
            for (int i = 1; i < start.size(); i++) if (start.get(i) < end.get(0)) n++;
            System.out.println(tags.substring(start.remove(0), end.remove(n)) + "/" + args[0] + ">");
        }
    }


}
