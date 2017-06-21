package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        File fIle = new File("C:\\Javarush\\in.txt");
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(fIle));
        System.out.println(personScannerAdapter.read().toString());
        System.out.println(personScannerAdapter.read().toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
//            String firstName = fileScanner.next();
//            String middleName = fileScanner.next();
//            String lastName = fileScanner.next();
//            String date1 = fileScanner.next();
//            String date2 = fileScanner.next();
//            String date3 = fileScanner.next();
//
//            return new Person(firstName, middleName, lastName, new Date(date1 + '/' + date2 + '/' + date3));
            String personData = fileScanner.nextLine();
            String[] parameters = personData.split(" ");

            return new Person(parameters[0], parameters[1], parameters[2], new Date(Integer.parseInt(parameters[5]) - 1900,
                    Integer.parseInt(parameters[4]) - 1,Integer.parseInt(parameters[3])));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
