package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long cntSearch;
    private static int N;
    private static int[] digitsMultiSet;
    private static List<Long> results;
    private static long maxPow;
    private static long minPow;
    private static long[][] pows;
    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }
    private static boolean check(long pow) {
        cntSearch++;
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;
        int[] testMultiSet = new int[10];
        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            pow = pow / 10;
        }
        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }
        return true;
    }
    private static void search(int digit, int unused, long pow) {
        if (digit == 10) {
            if (check(pow)) results.add(pow);
            return;
        }
        if (digit == 9) {
            digitsMultiSet[digit] = unused;
            search(digit + 1, 0, pow + unused * pows[digit][N]);
        } else {
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit + 1, unused - i, pow + i * pows[digit][N]);
            }
        }
    }
    public static List<Long> generate(int maxN) {
        if (maxN >= 20) throw new IllegalArgumentException();
        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        cntSearch = 0;
        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);
            search(0, N, 0);
        }
        Collections.sort(results);
        return results;
    }
    public static long[] getNumbers(long N) {
//        List<Long> list = new ArrayList<>();
//        for (long i = 0; i < N; i++) {
//            String stringValue = String.valueOf(i);
//            Long sum = 0L;
//            for (int j = 0; j < stringValue.length(); j++) {
//                sum += (long) Math.pow(Long.parseLong(Character.valueOf(stringValue.charAt(j)).toString()), stringValue.length());
//            }
//            if(sum.toString().equals(stringValue)) {
//                list.add(sum);
//            }
//        }
//        for(Long l : list) {
//            System.out.println(l);
//        }
        List<Long> list = generate((int) (Math.log10(N)));
        return list.stream().mapToLong(l -> l).toArray();
    }

    public static void main(String[] args) {
//        getNumbers(9000000000000000000L);
    }
}
