package com.example.java8feature.filterobjectbyproperty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "b");
        List<String> newList = strList.stream().filter(str -> str.equals("a")).collect(Collectors.toList());
        System.out.println(newList);
    }
}
