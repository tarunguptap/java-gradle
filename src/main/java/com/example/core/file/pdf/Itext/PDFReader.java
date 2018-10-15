package com.example.core.file.pdf.Itext;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDFReader {
    private static String FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/pdf/Maya_classic_8x10.pdf";

    public static void main(String[] args) {

        PdfReader reader;

        try {

            reader = new PdfReader(FILENAME);

            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

            System.out.println(textFromPage);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
