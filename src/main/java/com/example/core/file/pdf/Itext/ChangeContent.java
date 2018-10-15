package com.example.core.file.pdf.Itext;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ChangeContent {

    private static String SRC_FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/pdf/Maya_classic_8x10.pdf";
    private static String DEST_FILENAME = "E://misc/testworkspace/java-gradle/src/main/java/com/example/core/file/pdf/Maya_classic_updated2.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        processPdf();
    }

    public static void processPdf() throws IOException, DocumentException {
        PdfReader reader = new PdfReader(SRC_FILENAME);
        PdfDictionary dict = reader.getPageN(0);
        PdfObject object = dict.getDirectObject(PdfName.CONTENTS);

        if (object instanceof PRStream) {
            PRStream stream = (PRStream) object;
            byte[] data = PdfReader.getStreamBytes(stream);
            String dd = new String(data);
            dd = dd.replace("Cuctom", "Custom");
            dd = dd.replace("MAYA", "MAAYA");
            dd = dd.replace("MAGICAL", "Beloved");
            stream.setData(dd.getBytes());
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DEST_FILENAME));
        stamper.close();
        reader.close();
    }
}
