package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();
        while (true) {
            String fileName = reader.readLine();
            if (!fileName.equals("end")) {
                files.add(fileName);
            } else {
                break;
            }
        }
        files.sort((o1, o2) -> {
            System.out.println(o1.indexOf(".part"));
            System.out.println(o2.indexOf(".part"));
            int index1 = Integer.parseInt(o1.substring(o1.indexOf(".part"), o1.length()));
            int index2 = Integer.parseInt(o2.substring(o2.indexOf(".part"), o2.length()));
            return index1 - index2;
        });
        String outFile = files.get(0).substring(0, files.get(0).indexOf(".part"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outFile));
        BufferedInputStream inputStream = null;
        for (String s : files) {
            inputStream = new BufferedInputStream(new FileInputStream(s));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            inputStream.close();
        }
        reader.close();
        outputStream.close();
    }
}
/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if(!fileName.equals("end")) {
            String[] parts = fileName.split("\\.");
            String outFile = parts[0] + '.' + parts[1];
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outFile));
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            while (!((fileName = reader.readLine()).equals("end"))) {
                inputStream = new BufferedInputStream(new FileInputStream(fileName));
                buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(buffer);

            }
            reader.close();
            outputStream.close();
            inputStream.close();
        }*/
