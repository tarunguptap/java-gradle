package com.example.core.file;

import java.io.FileWriter;
import java.io.IOException;

import com.example.core.ImeiGenerator.ImeiGenerator;

public class B2BAutoProcessFileWriter {

    public static void main(String args[]) {
        try {
            createFile("20031918000001", "1Z1234466871201", "102057",
                    "E://AutoProcess/B2B/b2b-autoprocess-dev-102057-5-items.txt");
            /*createFile("20030718000005", "1Z1234466871140", "102058",
                    "E://AutoProcess/B2B/b2b-autoprocess-dev-102058-1.txt");
            createFile("20030718000005", "1Z1234466871140", "102059",
                    "E://AutoProcess/B2B/b2b-autoprocess-dev-102059-1.txt");
            createFile("20030718000005", "1Z1234466871140", "102161",
                    "E://AutoProcess/B2B/b2b-autoprocess-dev-102161-1.txt");*/
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }

    /**
     * Quote has 10 trades corresponding to each modelcode. we are creating a file with 5 exact match and 10 new trades.
     * 
     * @param hylaQuoteNumber
     * @param trackingNumber
     * @param hylaItemId
     * @param fileName
     * @throws IOException
     */
    private static void createFile(String hylaQuoteNumber, String trackingNumber, String itemId, String fileName)
            throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write("ORDER_DATE|UPDATE_DATE|ORDER_NUMBER|LOCATION_CODE|TRACKING_NUMBER_SHIP_OUT|SHIP_DATE|TRACKING_NUMBER_RETURN_LABEL|DOCK_RECEIPT_DATE|DEVICE_RECEIPT_DATE|PROCESS_DATE|DEVICE_ID_EXP|DEVICE_ID_RCV|VERIZON_SKU_EXP|VERIZON_SKU_RCV|EXPECTED_DEVICE_ID|LOST_STOLEN_FLG|HYLA_ITEM_ID|HYLA_QUOTE_NUMBER|ITEM_ID|DEVICE_RECEIVED_LOCATION_ID|XPO_SKU|XPO_GRADE|INSPECTION_MANUFACTURER|INSPECTION_MODEL|INSPECTION_CAPACITY|INSPECTION_CARRIER|INSPECTION_COLOR|Q1|A1|Q2|A2");
        for (int i = 0; i < 5; i++) {
            String value = ImeiGenerator.generateIMEI();
            fw.append("\n10/03/2016 20:07|10/16/2016|20161004_1|N396601|" + trackingNumber + "||" + trackingNumber
                    + "|10/12/2016|10/13/2016|10/15/2016|" + value + "|" + value + "||ME343LL/A|Y|N||"
                    + hylaQuoteNumber + "|" + itemId
                    + "|CRTC|CLNRAPL5S16GD-TPC|TPCN|APPLE|IPHONE3G|16GB|OTHER|Black|2|NO|1|YES");
        }
        itemId = "102062";
        for (int i = 0; i < 0; i++) {
            String value = ImeiGenerator.generateIMEI();
            fw.append("\n10/03/2016 20:07|10/16/2016|20161004_1|N396601|" + trackingNumber + "||" + trackingNumber
                    + "|10/12/2016|10/13/2016|10/15/2016|" + value + "|" + value + "||ME343LL/A|Y|N||"
                    + hylaQuoteNumber + "|" + itemId
                    + "|CRTC|CLNRAPL5S16GD-TPC|TPCN|APPLE|IPHONE3G|16GB|OTHER|Black|2|NO|1|YES");
        }
        fw.close();
    }
}
