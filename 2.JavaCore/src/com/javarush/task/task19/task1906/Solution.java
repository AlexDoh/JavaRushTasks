package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = inputReader.readLine();
        String file2 = inputReader.readLine();
        inputReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        int i = 1;
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            if(i % 2 == 0) {
                writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
            }
            i++;
        }

        //закрываем потоки после использования
        reader.close();
        writer.close();
    }
}
