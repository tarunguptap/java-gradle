package com.example.java8feature.filterobjectbyproperty;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.java8feature.dto.Customer;

public class AllMatch {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();
        String addressType = "HOME";
        if (Optional
                .ofNullable(customerSet)
                .orElseGet(Collections::emptySet)
                .stream()
                .allMatch(
                        customer -> Objects.nonNull(customer.getAddress())
                                && addressType.equals(customer.getAddress().getAddressType()))) {
            System.out.println("All the objects have same address type as that of addressType " + addressType);
        } else {
            System.out.println("All the objects doesn't have same address type as that of addressType " + addressType);
        }
    }

}
