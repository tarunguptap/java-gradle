package com.example.java8feature.filterobjectbyproperty;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.java8feature.dto.Customer;

public class Count {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();
        String addressType = "HOME";
        Long count = Optional
                .ofNullable(customerSet)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(customer -> Objects.nonNull(customer.getAddress())
                        && addressType.equals(customer.getAddress().getAddressType())).count();

        System.out.println("The count of customer having " + addressType + " is " + count);

        System.out.println("The matching count is " + validateNullSafe(new HashSet<Customer>(), addressType));

        System.out.println("The matching count is " + validateNullSafe(null, addressType));

    }

    /**
     * This method throws null pointer exception if user passes null collection. To make it null safe instead of adding
     * stream on customerSet, we have to make customerSet null safe with below \
     * Optional.ofNullable(customerSet).orElseGet(Collections::emptySet)
     */
    public static Long validateNullSafe(Set<Customer> customerSet, String addressType) {
        return customerSet
                .stream()
                .filter(customer -> Objects.nonNull(customer.getAddress())
                        && addressType.equals(customer.getAddress().getAddressType())).count();
    }

}
