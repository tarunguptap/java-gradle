package com.example.java8feature.filterobjectbyproperty;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.java8feature.dto.Customer;

public class AnyMatch {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();
        String addressType = "HOME";
        if (Optional
                .ofNullable(customerSet)
                .orElseGet(Collections::emptySet)
                .stream()
                .anyMatch(
                        customer -> Objects.nonNull(customer.getAddress())
                                && addressType.equals(customer.getAddress().getAddressType()))) {
            System.out.println("match found");
        } else {
            System.out.println("no match found");
        }
    }

}
