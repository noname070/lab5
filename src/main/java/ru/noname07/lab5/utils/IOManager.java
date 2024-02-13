package ru.noname07.lab5.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOManager {

    public static void writeToFile(String filePath, String rawData) throws IOException {
        try (BufferedOutputStream bOutputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytes = rawData.getBytes();
            bOutputStream.write(bytes);
            bOutputStream.close();
        }
    }

    public static void addToFile(String filePath, String rawData) throws IOException {
        try (BufferedOutputStream bOutputStream = new BufferedOutputStream(new FileOutputStream(filePath, true))) {
            byte[] bytes = (rawData + "\n").getBytes();
            bOutputStream.write(bytes);
            bOutputStream.close();
        }
    }

    public static String readFromFile(String filePath) throws IOException {
        try (BufferedInputStream bInputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] bytes = bInputStream.readAllBytes();
            bInputStream.close();
            return new String(bytes);
        }
    }

}
