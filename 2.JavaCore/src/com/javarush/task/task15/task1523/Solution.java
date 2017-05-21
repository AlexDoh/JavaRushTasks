package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    String name;
    int age;
    int price;

    private Solution(){
    }

    protected Solution(String name){
    }

    Solution(int age){
    }

    public Solution(String name, int age){

    }
    public static void main(String[] args) {

    }
}

