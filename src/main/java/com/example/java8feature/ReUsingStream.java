package com.example.java8feature;

import java.util.stream.Stream;

import com.example.java8feature.dto.Customer;


public class ReUsingStream {
	public static void main(String[] args) {
		Customer customer1 = new Customer(1L, "arun");
        Customer customer2 = new Customer(2L, "amit");
        Customer customer3 = new Customer(2L, "varun");
		Stream<Customer> stream = Stream.of(customer1, customer2);
		
	}
}
