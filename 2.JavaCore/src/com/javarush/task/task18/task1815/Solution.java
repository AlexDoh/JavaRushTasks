package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface original;
        private List list;
        private String headerText;

        TableInterfaceWrapper(ATableInterface original) {
            this.original = original;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            original.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return original.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            original.setHeaderText(newHeaderText);
            headerText = newHeaderText;
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}