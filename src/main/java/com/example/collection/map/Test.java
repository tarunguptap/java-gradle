package com.example.collection.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> holdInformation = new HashMap<>();
        Date holdEndDate = (Date) holdInformation.get("holdEndDate");
        System.out.println(holdEndDate);
    }

}
