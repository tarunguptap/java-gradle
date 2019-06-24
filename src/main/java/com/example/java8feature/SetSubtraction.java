package com.example.java8feature;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetSubtraction {
    public static void main(String[] args) {
        Set<String> existingSet = new HashSet<>(Arrays.asList("1", "2", "3"));
        Set<String> newSet = new HashSet<>(Arrays.asList("3", "4", "5"));

        existingSet.removeIf(e -> !newSet.contains(e));

        System.out.println(existingSet);

    }
}
