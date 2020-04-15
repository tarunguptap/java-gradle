package com.example.core.file.pdf.Itext.PasswordProtected;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class EncryptSalarySlip {

    // private static String FILENAME =
    // "F:/Tarun Gupta/Personal/Personal/Salary Slips/Statement_of_Total_Income(2018-2019).pdf";

    // private static String destination =
    // "F:/Tarun Gupta/Personal/Personal/Salary Slips/enc/Statement_of_Total_Income(2018-2019).pdf";

    private static String FILENAME = "C:/Users/tgupta/Downloads/Payslip.pdf";
    private static String destination = "C:/Users/tgupta/Downloads/TARUNGUPTA_NOV2019.pdf";

    private static String FILENAME1 = "C:/Users/tgupta/Downloads/Statement_of_Total_Income_2019-2020.pdf";
    private static String destination1 = "C:/Users/tgupta/Downloads/Statement_of_Total_Income_2019-2020.pdf1";
    /*
     * private static String FILENAME = "F:/Tarun Gupta/Personal/Personal/Salary Slips/Form16(2019-2020).pdf";
     * 
     * private static String destination = "F:/Tarun Gupta/Personal/Personal/Salary Slips/enc/Form16(2019-2020).pdf";
     */

    /** User password. Add password here */
    public static byte[] USER = "tarung16".getBytes();
    /** Owner password. */
    public static byte[] OWNER = "tarung16".getBytes();

    public static void main(String[] args) throws DocumentException {

        try {

            PdfReader reader = new PdfReader(FILENAME1);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destination1));

            stamper.setEncryption(USER, OWNER, PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128
                    | PdfWriter.DO_NOT_ENCRYPT_METADATA);
            stamper.close();
            reader.close();

            File file = new File(FILENAME);
            file.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
