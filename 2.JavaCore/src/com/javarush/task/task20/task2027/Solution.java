package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        detectAllWords(crossword, "home", "same", "masu");
        detectAllWords(crossword, "home", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop", "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "voel", "lock", "r", "re", "eo", "oe", null, "", " ");
//        detectAllWords(crossword,  null, "", " ");
//        detectAllWords(crossword, "masu", "eejj", "vok", "ovhj", "home", "arrj", "mglp", "prek");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int height = crossword.length;
        int width = crossword[0].length;
        int countTrueWords = 0;
        // Переносим в новый массив слов те из них, которые не null и не пустые.
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && words[i] != "") {
                countTrueWords++;
            }
        }
        String[] words1 = new String[countTrueWords]; // Это новый массив уменьшенный на
        // количество пустых и null строк
        countTrueWords = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && words[i] != "") {
                words1[countTrueWords] = words[i];
                countTrueWords++;
            }
        }
        // Список для результирующих элементов
        List<Word> result = new ArrayList<>();
        for (int i = 0; i < words1.length; i++) { // Начинаем перебирать слова из массива
            char[] word = words1[i].toCharArray(); // Разбиваем очередное слово на массив символов
            int sizeWord = word.length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (word[0] == crossword[y][x]) { // Ищем первую букву слова в матрице
                        if (sizeWord > 1) {  // Если слово больше чем из одной буквы, то идем по true
                            boolean left = false, right = false, up = false, down = false;
                            int count, trueCount, currentX, currentY;
                            // Выясняю возможные направления разгадывания в кроссворде исходя из длины слова
                            if (x + 1 - sizeWord >= 0) {left = true;}
                            if (x + sizeWord <= width) {right = true;}
                            if (y + 1 - sizeWord >= 0) {up = true;}
                            if (y + sizeWord <= height) {down = true;}
                            // Прощупываю доступные направления
                            if (left) { // Можно налево
                                count = 1;
                                trueCount = 1;
                                currentX = x - 1;
                                currentY = y;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentX--;
                                    } else break;
                                    count++;
                                }
                                currentX++;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (left && up) { // Влево и вверх
                                count = 1;
                                trueCount = 1;
                                currentX = x - 1;
                                currentY = y - 1;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentX--;
                                        currentY--;
                                    } else break;
                                    count++;
                                }
                                currentX++;
                                currentY++;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (up) { // Вверх
                                count = 1;
                                trueCount = 1;
                                currentX = x;
                                currentY = y - 1;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentY--;
                                    } else break;
                                    count++;
                                }
                                currentY++;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (right && up) { // Вправо и вверх
                                count = 1;
                                trueCount = 1;
                                currentX = x + 1;
                                currentY = y - 1;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentX++;
                                        currentY--;
                                    } else break;
                                    count++;
                                }
                                currentX--;
                                currentY++;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (right) { // Вправо
                                count = 1;
                                trueCount = 1;
                                currentX = x + 1;
                                currentY = y;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentX++;
                                    } else break;
                                    count++;
                                }
                                currentX--;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (right && down) { // Вправо и вниз
                                count = 1;
                                trueCount = 1;
                                currentX = x + 1;
                                currentY = y + 1;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentX++;
                                        currentY++;
                                    } else break;
                                    count++;
                                }
                                currentX--;
                                currentY--;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (down) { // Вниз
                                count = 1;
                                trueCount = 1;
                                currentX = x;
                                currentY = y + 1;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentY++;
                                    } else break;
                                    count++;
                                }
                                currentY--;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                            if (left && down) { // Влево и вниз
                                count = 1;
                                trueCount = 1;
                                currentX = x - 1;
                                currentY = y + 1;
                                // Здесь проверяю дальнейшее совпадение всех букв из слова
                                while (count < sizeWord) {
                                    if (word[count] == crossword[currentY][currentX]) {
                                        trueCount++;
                                        currentX--;
                                        currentY++;
                                    } else break;
                                    count++;
                                }
                                currentX++;
                                currentY--;
                                // Добавляю слово в результирующий список в случае полного совпадения
                                if (trueCount == sizeWord) {
                                    Word tempWord = new Word(words1[i]);
                                    tempWord.setStartPoint(x, y);
                                    tempWord.setEndPoint(currentX, currentY);
                                    result.add(tempWord);
                                }
                            }
                        }
                        else { // Здесь добавляю слова из одного символа, найденные в кроссворде
                            Word tempWord = new Word(words1[i]);
                            tempWord.setStartPoint(x, y);
                            tempWord.setEndPoint(x, y);
                            result.add(tempWord);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
//    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//        List<Word> listOfWords = new ArrayList<>();
//        List<Word> listOfAllWords;
//        for (String word : words) {
//            if (word != null) {
//                if(!word.equals(" ") && !word.equals("") && word.length() >= 1) {
//                    for (int i = 0; i < crossword.length; i++) {
//                        for (int j = 0; j < crossword[i].length; j++) {
//                            if (crossword[i][j] == word.charAt(0)) {
//                                listOfAllWords = findAllWords(crossword, word, j, i);
//                                for(Word anyWord : listOfAllWords) {
//                                    if(anyWord.toString().substring(0, word.length()).equals(word)) {
//                                        listOfWords.add(anyWord);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
////        for(Word word : listOfWords) {
////            System.out.println(word);
////        }
//        return listOfWords;
//    }
//
//    public static List<Word> findAllWords(int[][] crossword, String word, int x, int y) {
//        List<Word> listOfAllWords = new ArrayList<>();
//        // x left
//        if (x + 1 >= word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j;
//            for (j = x - 1; j > x - word.length(); j--) {
//                foundWord.append((char) crossword[y][j]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(j + 1, y);
//            listOfAllWords.add(addedWord);
//        }
//        // x right
//        if (crossword[y].length - x >= word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j;
//            for (j = x + 1; j < x + word.length(); j++) {
//                foundWord.append((char) crossword[y][j]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(j - 1, y);
//            listOfAllWords.add(addedWord);
//        }
//        // y up
//        if (y + 1 >= word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j;
//            for (j = y - 1; j > y - word.length(); j--) {
//                foundWord.append((char) crossword[j][x]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(x, j + 1);
//            listOfAllWords.add(addedWord);
//        }
//        // y down
//        if (crossword[y].length - y > word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j;
//            for (j = y + 1; j < y + word.length(); j++) {
//                foundWord.append((char) crossword[j][x]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(x, j - 1);
//            listOfAllWords.add(addedWord);
//        }
//        // left up
//        if (x + 1 >= word.length() && y + 1 >= word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j, i;
//            for (j = x - 1, i = y - 1; j > x - word.length() || i > y - word.length(); j--, i--) {
//                foundWord.append((char) crossword[i][j]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(j + 1, i + 1);
//            listOfAllWords.add(addedWord);
//        }
//        // right up
//        if (crossword[y].length - x >= word.length() && y + 1 >= word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j, i;
//            for (j = x + 1, i = y - 1; j < x + word.length() || i > y - word.length(); j++, i--) {
//                foundWord.append((char) crossword[i][j]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(j - 1, i + 1);
//            listOfAllWords.add(addedWord);
//        }
//        // left down
//        if (x + 1 >= word.length() && crossword[y].length - y > word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j, i;
//            for (j = x - 1, i = y + 1; j > x - word.length() || i < y + word.length(); j--, i++) {
//                foundWord.append((char) crossword[i][j]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(j + 1, i - 1);
//            listOfAllWords.add(addedWord);
//        }
//        // right down
//        if (crossword[y].length - x >= word.length() && crossword[y].length - y > word.length()) {
//            StringBuilder foundWord = new StringBuilder().append(word.charAt(0));
//            int j, i;
//            for (j = x + 1, i = y + 1; j < x + word.length() || i < y + word.length(); j++, i++) {
//                foundWord.append((char) crossword[i][j]);
//            }
//            Word addedWord = new Word(foundWord.toString());
//            addedWord.setStartPoint(x, y);
//            addedWord.setEndPoint(j - 1, i - 1);
//            listOfAllWords.add(addedWord);
//        }
//
//        return listOfAllWords;
//    }
