package com.example.core.string;

public class DynamicStringArgPlaceHolder {

    public static void main(String[] args) {
        String inputString = "Wrong value - you entered %1$s but it was actually %2$s";
        String parameterizedValue = "1,2";

        System.out.println(updateDynamicArgsInString(inputString, parameterizedValue));
    }

    private static String updateDynamicArgsInString(String inputString, String parameterizedValue) {
        return String.format(inputString, (Object[]) parameterizedValue.split(","));
    }

}
