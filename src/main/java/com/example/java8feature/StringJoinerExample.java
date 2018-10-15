package com.example.java8feature;

import java.util.StringJoiner;

import org.apache.commons.lang.StringUtils;

public class StringJoinerExample {

    public static void main(String[] args) {
        String str = null;
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("tarun");
        joiner.add("");
        System.out.println(joiner);

        StringBuilder record = new StringBuilder();
        record.append("QuoteNumber");
        record.append(",");
        record.append("TrackingNumber");
        record.append(",");
        if (StringUtils.isNotEmpty(str)) {
            record.append(str);
        }
        record.append(",");
    }

}
