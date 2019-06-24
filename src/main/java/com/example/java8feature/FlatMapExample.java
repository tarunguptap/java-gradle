package com.example.java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class FlatMapExample {

    public enum ExampleType {
        TEST, ROLLOVER, PARENT, CHILD
    }

    private static String PARENT_EXAMPLE_TYPES = "parent, child";

    public static void main(String[] args) {

        System.out.println("old way using StringTokenizer and Enumeration " + getFinalList());

        // New way using Stream API
        List<ExampleType> exampleTypes = Arrays.stream(PARENT_EXAMPLE_TYPES.trim().split("\\s*,\\s*"))
                .map(String::toUpperCase)
                .flatMap(token -> Arrays.stream(ExampleType.values()).filter(ct -> ct.name().equals(token)))
                .collect(Collectors.toList());
        System.out.println("New way using stream api " + exampleTypes);
    }

    // old way
    public static List<ExampleType> getFinalList() {
        List<ExampleType> exampleTypes = new ArrayList<>();
        StringTokenizer tokens = new StringTokenizer(PARENT_EXAMPLE_TYPES, ",");
        List<ExampleType> exampleTypesList = Arrays.asList(ExampleType.values());
        String token;
        while (tokens.hasMoreElements()) {
            token = ((String) tokens.nextElement()).trim().toUpperCase();
            for (ExampleType ct : exampleTypesList) {
                if (ct.name().equals(token)) {
                    exampleTypes.add(ct);
                    break;
                }
            }
        }
        return exampleTypes;
    }

}
