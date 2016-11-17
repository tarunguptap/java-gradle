package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericWithMinMaxDynamicLength {

    public static void main(String[] args) {
        String inputValue = "1234567898";//OUTPUT : false
        String inputValue1 = "123456789";//OUTPUT : true
        String inputValue2 = "";//OUTPUT : false
        String parameterizedValue = "1,9";
        String parameterizedValue1 = "0,9";
        System.out.println("inputValue & parameterizedValue : "
                + checkANumericDynamicMinMaxLength(inputValue, parameterizedValue));
        System.out.println("inputValue1 & parameterizedValue : "
                + checkANumericDynamicMinMaxLength(inputValue1, parameterizedValue));
        System.out.println("inputValue2 & parameterizedValue : "
                + checkANumericDynamicMinMaxLength(inputValue2, parameterizedValue));
        System.out.println("inputValue2 & parameterizedValue1 : "
                + checkANumericDynamicMinMaxLength(inputValue2, parameterizedValue1));
    }

    private static boolean checkANumericDynamicMinMaxLength(String inputValue, String minMaxLengthParameterValue) {
        return validateInput(
                updateDynamicArgsInString(RejexConstants.NUMERIC_WITH_DYNAMIC_MIN_MAX_LENGTH,
                        minMaxLengthParameterValue), inputValue);
    }

    private static String updateDynamicArgsInString(String inputString, String parameterizedValue) {
        return String.format(inputString, (Object[]) parameterizedValue.split(","));
    }

    private static boolean validateInput(String pattern, String temp) {
        boolean result = false;
        Pattern pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(temp);
        result = match.matches();
        return result;
    }
}
