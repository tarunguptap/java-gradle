package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintListElements {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("aman", "arun", "bharti", "chandan", "chakram");

        // To print the list elements
        lst.forEach(x -> System.out.println(x));

        System.out.println("========================================");

        // to transform and print the list elements
        lst.forEach(x -> System.out.println("* " + x + " *"));
        System.out.println("========================================");
        // to filter and print the list elements
        // For performing the filtering operations, the streaming should be done
        lst.stream().filter(s -> s.contains("c")).forEach(s -> System.out.println(s));
        System.out.println("========================================");
        // with sorting
        lst.stream().filter(s -> s.startsWith("c")).sorted().forEach(s -> System.out.println(s));
        System.out.println("========================================");
        // to convert list into map
        System.out.println("========================================");
        lst.stream().filter(s -> s.contains("c")).sorted().map(String::toUpperCase).forEach(s -> System.out.println(s));
        // Note : String::toUpperCase is a method refernce
        System.out.println("========================================");
        lst.stream().filter(s -> s.contains("c")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));
        System.out.println("========================================");

        List<String> filteredList = lst.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(filteredList);

    }
}
