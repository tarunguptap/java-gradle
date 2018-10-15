package com.example.core.file.reader;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Both FileInputStream and FileReader are abstractions to read data from source, which can be either file or socket,
 * but main difference between them is, InputStream is used to read binary data, while Reader is used to read text data,
 * precisely Unicode characters.
 * 
 *
 * Reader can either use default character encoding of platform on which your Java program is running or accept a
 * Charset object or name of character encoding in String format e.g. "UTF-8". Despite being one of the simplest
 * concept, lots of Java developers make mistakes of not specifying character encoding, while reading text files or text
 * data from socket.
 *
 * Remember, if you don't specify correct encoding, or your program is not using character encoding already present in
 * protocol e.g. encoding specified in "Content-Type" for HTML files and encoding presents in header of XML files, you
 * may not read all data correctly. Some characters which are not present in default encoding, may come up as ? or
 * little square.
 * 
 * Bottom line is use FileReader or BufferedReader to read stream of characters or text data from File and always
 * specify character encoding.
 */
public class FileInputStreamExample {
    private static String FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/reader/test.csv";

    public static void main(String[] args) {
        // Example 1 - Reading File's content using FileInputStream
        try (FileInputStream fis = new FileInputStream(FILENAME)) {
            int data = fis.read();
            while (data != -1) {
                System.out.print(Integer.toHexString(data));
                data = fis.read();
            }
        } catch (IOException e) {
            System.out.println("Failed to read binary data from File");
            e.printStackTrace();
        }
    }
}
