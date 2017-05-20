package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put((double) '1', "yolo");
        labels.put(1.5d, "kolo");
        labels.put(new Double(77), "kulo");
        labels.put(1.51, "kofo");
        labels.put(1.555, "kogho");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
