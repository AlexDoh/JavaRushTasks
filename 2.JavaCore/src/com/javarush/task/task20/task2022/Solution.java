package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    public transient FileOutputStream stream;
    public String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Javarush\\keefo.txt");
        Solution solution = new Solution("C:\\Javarush\\keefo.txt");
//        solution.writeObject("yolo");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(solution.stream);
        objectOutputStream.writeObject(solution);
        objectOutputStream.close();
        BufferedInputStream output = new BufferedInputStream(new FileInputStream("C:\\Javarush\\keefo.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(output);
        objectInputStream.readObject();
    }
}
