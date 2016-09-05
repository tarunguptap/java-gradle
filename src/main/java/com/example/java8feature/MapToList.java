package com.example.java8feature;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
    public static void main(String[] args) {
        // To get the map keys as list
        List<Long> customerIdList = ListToMap.getCustomerMap().entrySet().stream().map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(customerIdList);

        // To get the map values as list
        List<Customer> customerObjList = ListToMap.getCustomerMap().entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(customerObjList);
    }
}
