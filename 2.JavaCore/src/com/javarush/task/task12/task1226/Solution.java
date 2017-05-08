package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public interface Fly{
        void fly();
    }

    public interface Climb{
        void climb();
    }

    public interface Run{
        void run();
    }

    public class Cat implements Climb,Run {
        public void run(){
            System.out.print("I can run");
        }

        public void climb(){
            System.out.print("I can climb");
        }
    }

    public class Dog implements Run {
        public void run(){
            System.out.print("I can run");
        }
    }

    public class Tiger extends Cat {
        public void run(){
            super.run();
        }

        public void climb(){
            super.climb();
        }
    }

    public class Duck implements Fly, Run {
        public void fly(){
            System.out.print("I can fly");
        }

        public void run(){
            System.out.print("I can run");
        }
    }
}
