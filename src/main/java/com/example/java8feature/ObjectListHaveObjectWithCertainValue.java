package com.example.java8feature;

import java.util.List;

import com.example.java8feature.dto.Customer;

public class ObjectListHaveObjectWithCertainValue {

    public static void main(String[] args) {
        List<Customer> customerList = Customer.getCustomerList();

        if (customerList.stream().filter(c -> c.getFirstname().equals("arun3")).findFirst().isPresent()) {
            System.out.println("arun3 is present");
        } else {
            System.out.println("arun3 is not present");
        }

        if (customerList.stream().map(Customer::getFirstname).filter("arun3"::equals).findFirst().isPresent()) {
            System.out.println("arun3 is present");
        } else {
            System.out.println("arun3 is not present");
        }
    }

}
