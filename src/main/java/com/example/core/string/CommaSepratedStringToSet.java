package com.example.core.string;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CommaSepratedStringToSet {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7";

        Set<Long> strSet = Arrays.stream(str.split(",")).map(Long::valueOf).collect(Collectors.toSet());

        String str1 = "1";
        System.out.println(Arrays.stream(str1.split(",")).map(Long::valueOf).collect(Collectors.toSet()));

        String str2 = "";
        System.out.println(Arrays.stream(str2.split(",")).map(Long::valueOf).collect(Collectors.toSet()));
    }

}
