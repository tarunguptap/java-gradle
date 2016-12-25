package com.example.core.array;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;

public class Binary {

    public static void main(String[] args) {
        String[] stringArray = { "TEST", "PAPER", "NEWS", "GET", "POST" };
        String stringToCheck = "GET";
        System.out.println("String is " + validateStringExistanceInarray(stringToCheck, stringArray));
        System.out.println("String is " + validateStringExistanceInarray("NAME", stringArray));

    }

    /**
     * This method first sorts the array then it perform the binary search to find the string
     * 
     * @param stringToCheck
     * @param stringArray
     * @return String
     */
    public static String validateStringExistanceInarray(String stringToCheck, String... stringArray) {
        Arrays.sort(stringArray);
        if (Objects.nonNull(stringToCheck) && Arrays.binarySearch(stringArray, stringToCheck) >= 0) {
            return stringToCheck;
        }
        return StringUtils.EMPTY;
    }
}
