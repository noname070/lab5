package ru.noname07.lab5.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOManager {
    
    public static void writeToFile(String filePath, String rawData) throws IOException {
        try (BufferedOutputStream bOutputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytes = rawData.getBytes();
            bOutputStream.write(bytes);
        }
    }

    public static String readFromFile(File file) throws IOException {
        try (BufferedInputStream bInputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = bInputStream.readAllBytes();
            return new String(bytes);
        }
    }

}
