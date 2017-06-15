package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static final BufferedReader readerInput = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedReader readerFile;
    public static String firstFile;
    public static String secondFile;

    static {
        try {
            firstFile = readerInput.readLine();
            secondFile = readerInput.readLine();
            readerFile = new BufferedReader(new FileReader(firstFile));
            while (true) {
                String line = readerFile.readLine();
                if (line == null) {
                    break;
                }
                allLines.add(line);
            }
            readerFile.close();
            for (String s : allLines) {
                System.out.println(s);
            }
            readerFile = new BufferedReader(new FileReader(secondFile));
            String line;
            while ((line = readerFile.readLine()) != null) {
                forRemoveLines.add(line);
            }
            for (String s : forRemoveLines) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        try {
            instance.joinData();
            for (String s : allLines) {
                System.out.println(s);
            }
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
