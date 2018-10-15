package com.example.java8feature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.java8feature.dto.Customer;

public class ObjectListToCommaSeparatedStringOfProperty {

    public static void main(String[] args) {
        Customer cust1 = new Customer(1L, "test1");
        Customer cust2 = new Customer(2L, "test2");
        Customer cust3 = new Customer(2L, "test3");
        Customer cust4 = new Customer(2L, "test4");
        Customer cust5 = new Customer(2L, "test5");

        List<Customer> custList = new ArrayList<>();
        custList.add(cust1);
        custList.add(cust2);
        custList.add(cust3);
        custList.add(cust4);
        custList.add(cust5);
        System.out.println(custList.stream().map(Customer::getFirstname).collect(Collectors.joining(", ")));

        Set<Customer> custSet = new HashSet<>();
        custSet.add(cust1);
        custSet.add(cust2);
        custSet.add(cust3);
        custSet.add(cust4);
        custSet.add(cust5);
        System.out.println(custSet.stream().map(Customer::getFirstname).collect(Collectors.joining(", ")));

    }

}
