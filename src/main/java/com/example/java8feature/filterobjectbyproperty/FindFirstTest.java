package com.example.java8feature.filterobjectbyproperty;

import java.util.ArrayList;
import java.util.List;

public class FindFirstTest {

    public static void main(String[] args) {
        List<String> gadgets = new ArrayList<>();
        gadgets.add("SmartPhone");
        gadgets.add("SmartWatch");
        gadgets.add("SmartTV");
        gadgets.add("SmartDoor");
        gadgets.add("iPhone");

        String item = gadgets.stream().filter(s -> s.length() > 8).findFirst().orElse("");
        System.out.println("In Java 8, first item: " + item);
    }
}
