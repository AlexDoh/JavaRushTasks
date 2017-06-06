package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //add your code here - добавьте код тут
    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        public String fileName;
        public String fileContent = "";

        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        public void run() {
            StringBuilder content = new StringBuilder();
            try {
                BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = readerFile.readLine()) != null) {
                    content.append(line).append(' ');
                }
                fileContent = content.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getFileContent() {
            return fileContent;
        }
    }
}
