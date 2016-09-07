package com.example.java8feature;

import java.util.Map;

import com.example.java8feature.dto.Customer;
import com.example.java8feature.dto.InitializerHelper;

public class ListToMap {
    public static void main(String[] args) {

        // To convert the list into map of id and object
        Map<Long, Customer> customerMap = InitializerHelper.getCustomerMap();
        System.out.println(customerMap.toString());
    }

    

    

}
