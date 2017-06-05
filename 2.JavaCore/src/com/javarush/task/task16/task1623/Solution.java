package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            this.start();
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }

        public void run() {
            if(countCreatedThreads < Solution.count) {
                try {
                    GenerateThread thread = new GenerateThread();
                    System.out.println(thread);
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
