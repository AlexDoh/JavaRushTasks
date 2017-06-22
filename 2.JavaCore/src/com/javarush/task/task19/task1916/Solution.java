package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader1 = new FileReader(reader.readLine());
             FileReader fileReader2 = new FileReader(reader.readLine())) {

            List<String> original = new BufferedReader(fileReader1).lines().collect(Collectors.toList());
            List<String> modified = new BufferedReader(fileReader2).lines().collect(Collectors.toList());

            while (original.size() != 0 & modified.size() != 0) {
                if (original.get(0).equals(modified.get(0))) {
                    lines.add(new LineItem(Type.SAME, original.remove(0)));
                    modified.remove(0);
                } else if (modified.size() != 1 && original.get(0).equals(modified.get(1))) {
                    lines.add(new LineItem(Type.ADDED, modified.remove(0)));
                } else if (original.size() != 1 && original.get(1).equals(modified.get(0))) {
                    lines.add(new LineItem(Type.REMOVED, original.remove(0)));
                }
            }

            if (original.size() != 0) {
                lines.add(new LineItem(Type.REMOVED, original.remove(0)));
            } else if (modified.size() != 0) {
                lines.add(new LineItem(Type.ADDED, modified.remove(0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(System.out::println);
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
//            if(line1 == null && line2 == null) {
//                break;
//            }
//
//            if("".equals(line2) || line2 == null) {
//                lines.add(new LineItem(Type.REMOVED, line1));
//                continue;
//            }
//            if("".equals(line1) || line1 == null) {
//                lines.add(new LineItem(Type.ADDED, line2));
//                continue;
//            }
////            assert line1 != null;
//            if(line1.equals(line2)) {
//                lines.add(new LineItem(Type.SAME, line1));
//            }
//        while (i < lines1.size()) {
//            if (i == lines2.size()) {
//                lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
//                lines1.remove(i);
//            } else if (lines1.get(i).equalsIgnoreCase(lines2.get(i))) {
//                lines.add(new LineItem(Type.SAME, lines1.get(i)));
//                lines1.remove(i);
//                lines2.remove(i);
//            } else if (lines1.get(i).equalsIgnoreCase(lines2.get(i + 1))) {
//                lines.add(new LineItem(Type.ADDED, lines2.get(i)));
//                lines2.remove(i);
//            } else if (!lines1.get(i).equalsIgnoreCase(lines2.get(i))) {
//                lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
//                lines1.remove(i);
//            }
//        }
//        if (lines1.size() == 0 && lines2.size() > 0) {
//            for (int j = 0; j < lines2.size(); j++) {
//                lines.add(new LineItem(Type.ADDED, lines2.get(j)));
//                lines2.remove(j);
//            }
//        }
