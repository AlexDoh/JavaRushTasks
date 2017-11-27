package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];

        for(int i = 0; i < solutions.length; i++) {
            Solution s = new Solution();
            solutions[i] = s;
            for(int j = 0; j < s.innerClasses.length; j++) {
                s.innerClasses[j] = s.new InnerClass();
            }
        }

        return solutions;
    }

    public static void main(String[] args) {

    }
}
