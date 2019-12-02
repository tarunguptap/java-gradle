package com.logical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://howtodoinjava.com/java8/java8-boxed-intstream/
public class ArrayToListBoxed {
    public static void main(String[] args) {
        int array[] = new int[] { 1, 2, 1, 2, 2, 3, 4, 3, 5 };

        List list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(list);

    }
}
