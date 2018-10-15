package com.example.core.file.reader;

import java.io.FileReader;

public class FileReaderExample {

    private static String FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/reader/test.csv";

    public static void main(String args[]) {
        try {
            FileReader fr = new FileReader(FILENAME);
            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("Success...");
    }
}
