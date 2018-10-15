package com.example.core.file.pdf.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFReader {
    private static String FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/pdf/Maya.pdf";

    public static void main(String[] args) throws IOException {

        try (PDDocument document = PDDocument.load(new File(FILENAME))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                // System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                    if (StringUtils.contains(line, "Cuctom")) {
                        System.out.println(line);
                    }
                }

            }

        }

    }
}
