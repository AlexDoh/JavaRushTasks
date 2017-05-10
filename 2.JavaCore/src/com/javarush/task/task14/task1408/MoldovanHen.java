package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    private final static int countOfEggsPerMonth = 2;
    private final static String country = Country.MOLDOVA;

    int getCountOfEggsPerMonth(){
        return countOfEggsPerMonth;
    }

    @Override
    String getDescription(){
        return String.format("%s Моя страна - %s. Я несу %s яиц в месяц.", super.getDescription(), country, getCountOfEggsPerMonth());
    }
}

