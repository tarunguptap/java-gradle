package com.example.java8feature.stream.file.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderExample {

    public static void main(String args[]) {
        try {
            String fileName = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/reader/test.csv";
            List<String> list = new ArrayList<>();
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }

            list.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("Success...");
    }
}
