package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
//        try {
        if (type == ImageTypes.BMP) {
            return new BmpReader();
        }
        if (type == ImageTypes.PNG) {
            return new PngReader();
        }
        if (type == ImageTypes.JPG) {
            return new JpgReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getClass().getSimpleName() + "(\"Неизвестный тип картинки\")");
//            return null;
//        }
    }
}
