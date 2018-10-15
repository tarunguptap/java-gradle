package com.example.java8feature.filterobjectbyproperty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfTwoList {
    public static void main(String[] args) {
        List<String> arrayList1 = Arrays.asList("TEST", "COMMON", "DISTINCT");
        List<String> arrayList2 = Arrays.asList("TEST1", "COMMON", "DISTINCT1");
        arrayList1.stream().filter(arrayList2::contains).collect(Collectors.toList()).forEach(System.out::println);
    }
}
