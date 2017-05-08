package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("govno" , 200);
        map.put("givno" , 300);
        map.put("dermo" , 400);
        map.put("dva" , 500);
        map.put("dinar" , 600);
        map.put("gamno" , 700);
        map.put("lajno" , 800);
        map.put("fekal" , 900);
        map.put("shit" , 1000);
        map.put("parasha" , 1100);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Integer> iterator = map.values().iterator();
        while(iterator.hasNext()){
            if(iterator.next() < 500){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}