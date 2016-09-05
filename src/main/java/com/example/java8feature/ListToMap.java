package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {

        // To convert the list into map of id and object
        Map<Long, Customer> customerMap = getCustomerMap();
        System.out.println(customerMap.toString());
    }

    public static Map<Long, Customer> getCustomerMap() {
        return getCustomerList().stream().collect(Collectors.toMap(x -> x.getId(), Function.identity()));
    }

    public static List<Customer> getCustomerList() {
        Customer customer1 = new Customer(1L, "arun1");
        Customer customer2 = new Customer(2L, "arun2");
        Customer customer3 = new Customer(3L, "arun3");
        Customer customer4 = new Customer(4L, "arun4");
        Customer customer5 = new Customer(5L, "arun5");
        Customer customer6 = new Customer(6L, "arun6");
        return Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6);
    }

}
