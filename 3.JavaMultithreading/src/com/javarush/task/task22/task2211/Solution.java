package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset w1251 = Charset.forName("Windows-1251");
        InputStream inputStream = new FileInputStream(args[0]);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String content = new String(buffer, utf8);
        buffer = content.getBytes(w1251);
        OutputStream outputStream = new FileOutputStream(args[1]);
        outputStream.write(buffer);
    }
}
