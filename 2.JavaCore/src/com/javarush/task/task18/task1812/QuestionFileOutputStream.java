package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream stream;

    QuestionFileOutputStream(AmigoOutputStream stream) {
        this.stream = stream;
    }

    @Override
    public void flush() throws IOException {
        this.stream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.stream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer = bufferedReader.readLine();
        if(answer.equals("Д")) {
            stream.close();
        }
    }
}

