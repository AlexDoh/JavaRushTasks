package com.javarush.task.task13.task1315;

/* 
Dog, Cat и Mouse
*/

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {

//        InputStream inStream = new FileInputStream("c:/source.txt");
//        OutputStream outStream = new FileOutputStream("c:/result.txt");
//
//        while (inStream.available() > 0)
//        {
//            int data = inStream.read(); //читаем один байт из потока для чтения
//            outStream.write(data); //записываем прочитанный байт в другой поток.
//        }
//
//        inStream.close(); //закрываем потоки
//        outStream.close();

    }

    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Dog implements Movable, Eat {
        public void move(){}
        public void eat(){}
    }

    public class Cat implements Movable, Eat, Eatable {
        public void move(){}
        public void eat(){}
        public void eaten(){}
    }

    public class Mouse implements Movable, Eatable {
        public void move(){}
        public void eaten(){}
    }
}