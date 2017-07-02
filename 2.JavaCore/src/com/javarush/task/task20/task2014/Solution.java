package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(new Solution(4));
        try {
            File file = new File("C:\\Javarush\\keefo.txt");
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            Solution savedObject = new Solution(4);
            objectOutputStream.writeObject(savedObject);
            Solution object = new Solution(5);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Solution loadedObject = (Solution) objectInputStream.readObject();
            objectInputStream.close();
            if(loadedObject.string.equals(savedObject.string)) {
                System.out.println("true");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
