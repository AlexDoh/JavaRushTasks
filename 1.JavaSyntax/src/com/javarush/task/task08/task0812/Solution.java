package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        int max = 1;
        for(i = 0;i < 10;i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        int counter = 1;
        for (i = 0; i < list.size()-1;i++){
            if(list.get(i).equals(list.get(i+1))){
                counter++;
            } else if (counter > max){
                max = counter;
                counter = 1;
            }
        }
//        if(counter > max){
//            max = counter;
//        }
        System.out.print(max);

    }
}
//        int max = 1, count = 1, xLast, xCurr;
//        for (int i=0; i <10; i++)
//        {
//        if (i>0)
//        {
//        xCurr = list.get(i);
//        xLast = list.get(i-1);
//        if (xLast == xCurr) count++; else  count=1;
//        if (count>max) max=count;
//        }
//        }
//        System.out.println(max);