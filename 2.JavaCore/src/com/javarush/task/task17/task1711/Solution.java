package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            Solution.addPerson(args[i], args[i + 1], args[i + 2]);
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            Solution.updatePerson(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Solution.deletePerson(Integer.parseInt(args[i]));
                        }
                    }
                    break;
                case "-i":
                    for (int i = 1; i < args.length; i++) {
                        synchronized (allPeople) {
                            Solution.getPerson(Integer.parseInt(args[i]));
                        }
                    }
                    break;
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
        System.out.print(allPeople.indexOf(person) + " ");
    }

    public static void updatePerson(int index, String name, String sex, String date) throws ParseException {
        Person p = allPeople.get(index);
        p.setName(name);
        p.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date));
        if (sex.equals("м")) {
            p.setSex(Sex.MALE);
        } else if (sex.equals("ж")) {
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
        if (p.getSex().equals(Sex.MALE)) {
            sex = "м";
        } else if (p.getSex().equals(Sex.FEMALE)) {
            sex = "ж";
        }
        System.out.print(p.getName() + " ");
        System.out.print(sex + " ");
        System.out.print(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
        System.out.println();
    }
}
