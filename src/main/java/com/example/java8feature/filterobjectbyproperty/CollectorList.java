package com.example.java8feature.filterobjectbyproperty;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.java8feature.dto.Customer;

public class CollectorList {
    public static void main(String[] args) {
        List<Customer> customerList = null;
        List<String> nameList = Optional.ofNullable(customerList).orElseGet(Collections::emptyList).stream()
                .map(customer -> customer.getFirstname()).collect(Collectors.toList());
        System.out.println(nameList.size());
    }
}
