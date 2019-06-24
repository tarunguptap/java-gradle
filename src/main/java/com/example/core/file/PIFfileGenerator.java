package com.example.core.file;

import java.io.FileWriter;
import java.io.IOException;

import com.example.core.ImeiGenerator.ImeiGenerator;

public class PIFfileGenerator {
    public static void main(String[] args) {
        String s = "ORDER_DATE|UPDATE_DATE|ORDER_NUMBER|LOCATION_CODE|TRACKING_NUMBER_SHIP_OUT|SHIP_DATE|TRACKING_NUMBER_RETURN_LABEL|DOCK_RECEIPT_DATE|DEVICE_RECEIPT_DATE|PROCESS_DATE|DEVICE_ID_EXP|DEVICE_ID_RCV|VERIZON_SKU_EXP|VERIZON_SKU_RCV|EXPECTED_DEVICE_ID|LOST_STOLEN_FLG|HYLA_ITEM_ID|ITEM_ID|DEVICE_RECEIVED_LOCATION_ID|XPO_SKU|XPO_GRADE|INSPECTION_MANUFACTURER|INSPECTION_MODEL|INSPECTION_CAPACITY|INSPECTION_CARRIER|INSPECTION_COLOR|Q1|A1|Q2|A2|Q3|A3|Q4|A4|Q5|A5|Q6|A6|Q7|A7|Q8|A8|Q9|A9|Q10|A10|HYLA_QUOTE_NUMBER";
        try {
            FileWriter fw = new FileWriter("e://pif1.txt");
            fw.write(s + System.lineSeparator());
            for (int i = 0; i < 20; i++) {
                String imei = ImeiGenerator.generateIMEI();
                s = "10/03/2016 20:07"
                        + "|"
                        + "10/16/2016"
                        + "|"
                        + "20161004_1"
                        + "|"
                        + "N396601"
                        + "|"
                        + "1123019902024"
                        + "||"
                        + "1123019902024"
                        + "|"
                        + "10/12/2016|10/13/2016|10/15/2016"
                        + "|"
                        + imei
                        + "|"
                        + imei
                        + "||ME343LL/A|Y|N|106810|106810|CRTC|CLNRAPL5S16GD-TPC|TPCN|APPLE|IPHONE3G|16GB|OTHER|Black1|2|NO|1|YES|||||||||||||||||"
                        + "20080318000001";
                fw.write(s + System.lineSeparator());
            }
            for (int i = 0; i < 20; i++) {
                String imei = ImeiGenerator.generateIMEI();
                s = "10/03/2016 20:07"
                        + "|"
                        + "10/16/2016"
                        + "|"
                        + "20161004_1"
                        + "|"
                        + "N396601"
                        + "|"
                        + "1123019902025"
                        + "||"
                        + "1123019902025"
                        + "|"
                        + "10/12/2016|10/13/2016|10/15/2016"
                        + "|"
                        + imei
                        + "|"
                        + imei
                        + "||ME343LL/A|Y|N|100240|100240|CRTC|CLNRAPL5S16GD-TPC|TPCN|APPLE|IPHONE3G|16GB|OTHER|Black1|2|NO|1|YES|||||||||||||||||"
                        + "20080318000002";
                fw.write(s + System.lineSeparator());
            }
            for (int i = 0; i < 20; i++) {
                String imei = ImeiGenerator.generateIMEI();
                s = "10/03/2016 20:07"
                        + "|"
                        + "10/16/2016"
                        + "|"
                        + "20161004_1"
                        + "|"
                        + "N396601"
                        + "|"
                        + "1123019902026"
                        + "||"
                        + "1123019902026"
                        + "|"
                        + "10/12/2016|10/13/2016|10/15/2016"
                        + "|"
                        + imei
                        + "|"
                        + imei
                        + "||ME343LL/A|Y|N|100750|100750|CRTC|CLNRAPL5S16GD-TPC|TPCN|APPLE|IPHONE3G|16GB|OTHER|Black1|2|NO|1|YES|||||||||||||||||"
                        + "20080318000003";
                fw.write(s + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
