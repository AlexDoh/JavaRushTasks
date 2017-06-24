package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new FileReader(args[0]));
        ArrayList<String> list = new ArrayList<>();

        while(reader.ready()) {
            String line = reader.readLine();
            String[] parts = line.split(" ");
            list.addAll(Arrays.asList(parts));
            Date date = new Date(Integer.parseInt(list.remove(list.size() - 1)) - 1900,
                    Integer.parseInt(list.remove(list.size() - 1)) - 1,
                    Integer.parseInt(list.remove(list.size() - 1)));
            StringBuilder name = new StringBuilder();
            while(!list.isEmpty()) {
                name.append(list.remove(0)).append(' ');
            }
            name.deleteCharAt(name.length() - 1);
            PEOPLE.add(new Person(name.toString(), date));

            PEOPLE.forEach(System.out::println);
        }
        reader.close();
    }
}
