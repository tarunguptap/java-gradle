package com.example.core.string;

import java.util.Objects;

public class VariableString {

    private static int COUNTER = 0;

    public static void main(String[] args) {
        printString("normal");
        printString("variable", "test");
        printString("variable", "test", "arun", "arjun", "aryan");
    }

    private static void printString(String str, String... variableString) {
        ++COUNTER;
        System.out.println("Normal String is : " + (COUNTER) + " : " + str);
        if (Objects.nonNull(variableString)) {
            for (String string : variableString) {
                System.out.println("Variable String is : " + (COUNTER) + " : " + string);
            }
        }
    }
}
