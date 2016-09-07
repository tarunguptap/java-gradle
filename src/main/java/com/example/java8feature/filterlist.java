package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.java8feature.dto.Customer;

public class filterlist {

    public List<Long> getIdListFromObjectList() {
        Customer customer1 = new Customer(1L, "arun1");
        Customer customer2 = new Customer(2L, "arun2");
        Customer customer3 = new Customer(3L, "arun3");
        Customer customer4 = new Customer(4L, "arun4");
        Customer customer5 = new Customer(5L, "arun5");
        Customer customer6 = new Customer(6L, "arun6");
        List<Customer> customerList = Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6);

        List<Long> ids = customerList.stream().map(customer -> customer.getId()).collect(Collectors.toList());
        System.out.println(ids);
        return ids;
    }

    public static void main(String[] args) {
        filterlist fl = new filterlist();
        fl.getIdListFromObjectList();
    }

}
