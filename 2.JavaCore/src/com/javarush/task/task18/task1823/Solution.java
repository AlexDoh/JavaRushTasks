package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!((fileName = reader.readLine()).equals("exit"))) {
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Integer, Integer> map = new HashMap<>();

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                InputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0) {
                    int oneByte = inputStream.read();
                    if(!map.containsKey(oneByte)) {
                        map.put(oneByte, 1);
                    } else {
                        map.put(oneByte, map.get(oneByte) + 1);
                    }
                }
                int max = Collections.max(map.values());
                for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if(pair.getValue().equals(max)) {
                        resultMap.put(fileName, pair.getKey());
                    }
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
