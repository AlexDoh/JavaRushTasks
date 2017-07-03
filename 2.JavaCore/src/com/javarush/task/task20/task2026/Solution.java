package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
//                {1, 1, 0, 0},
//                {1, 1, 0, 0},
//                {1, 1, 0, 0},
//                {1, 1, 0, 1}

                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                byte x, y;
                int tempI = i;
                int tempJ = j;
                if (a[i][j] == 1) {
                    count++;
                    while (j < a[i].length) {
                        if (a[i][j] == 0) {
                            break;
                        }
                        j++;
                    }
                    int k = j;
                    j = tempJ;
                    while (i < a.length) {
                        if (a[i][j] == 0) {
                            break;
                        }
                        i++;
                    }
                    if (j > 0 || i > 0) {
                        a = replaceWithZero(a, tempJ, k, tempI, i);
                    } else {
                        a[i][j] = 0;
                    }
                    i = tempI;
                }
            }
        }
        return count;
    }

    public static byte[][] replaceWithZero(byte[][] b, int xStart, int xFin, int yStart, int yFin) {
        for (int i = yStart; i < yFin; i++) {
            for (int j = xStart; j < xFin; j++) {
                b[i][j] = 0;
            }
        }
        return b;
    }
}
