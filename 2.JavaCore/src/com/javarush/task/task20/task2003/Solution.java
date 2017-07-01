package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        load(new FileInputStream(reader.readLine()));
        reader.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        Properties myProperties = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            myProperties.setProperty(pair.getKey(), pair.getValue());
        }
        myProperties.store(outputStream, null);
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        properties.putAll((Map)myProperties);
        inputStream.close();
    }

    public static void main(String[] args) throws IOException {
    }
}
