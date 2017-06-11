package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {

            if (args[0].equals("-c")) {
                Solution.addPerson(args[1], args[2], args[3]);
            }
            if (args[0].equals("-u")) {
                Solution.updatePerson(Integer.parseInt(args[1]), args[2], args[3], args[4]);
            }
            if (args[0].equals("-d")) {
                Solution.deletePerson(Integer.parseInt(args[1]));
            }
            if (args[0].equals("-i")) {
                Solution.getPerson(Integer.parseInt(args[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPerson(String name, String sex, String date) throws ParseException {
        Person person = null;
        if (sex.equals("м")) {
            person = Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date));
        }
        if (sex.equals("ж")) {
            person = Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date));
        }
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }

    public static void updatePerson(int index, String name, String sex, String date) throws ParseException {
        Person p = allPeople.get(index);
        p.setName(name);
        p.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date));
        if(sex.equals("м"))
        {
            p.setSex(Sex.MALE);
        }
        else if(sex.equals("ж"))
        {
            p.setSex(Sex.FEMALE);
        }
        allPeople.set(index, p);
    }

    public static void deletePerson(int index) throws ParseException {
        Person p = allPeople.get(index);
        p.setName(null);
        p.setSex(null);
        p.setBirthDay(null);
        allPeople.set(index, p);
    }

    public static void getPerson(int index) throws ParseException {
        Person p = allPeople.get(index);
        String sex = null;
        if(p.getSex().equals(Sex.MALE))
        {
            sex = "м";
        }
        else if(p.getSex().equals(Sex.FEMALE))
        {
            sex = "ж";
        }
        System.out.print(p.getName() + " ");
        System.out.print(sex + " ");
        System.out.print(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
    }
}
