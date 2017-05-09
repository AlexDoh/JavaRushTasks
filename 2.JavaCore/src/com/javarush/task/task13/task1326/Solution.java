package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();

        InputStream readerFile = new FileInputStream(filename);
        Scanner sc =  new Scanner(readerFile);

        while(sc.hasNextInt()){
            int number = sc.nextInt();
            if(number % 2 == 0){
                list.add(number);
            }
        }
        Collections.sort(list);

        for(int n : list){
            System.out.println(n);
        }

        reader.close();
        readerFile.close();
    }
}
