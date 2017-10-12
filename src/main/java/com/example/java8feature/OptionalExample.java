package com.example.java8feature;

import java.util.Optional;

import com.example.java8feature.dto.Customer;

public class OptionalExample {

    public OptionalExample() {

    }

    public static void main(String[] args) {
        Customer customer = null;
        Optional<String> optionalResponse = Optional.ofNullable(customer.getFirstname());
        if (optionalResponse.isPresent()) {
            System.out.println("first name is : " + optionalResponse.get());

        }
    }

}
