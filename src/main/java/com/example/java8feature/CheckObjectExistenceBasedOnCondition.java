package com.example.java8feature;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.java8feature.dto.Customer;

public class CheckObjectExistenceBasedOnCondition {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();
        System.out.println("Matching home address found : " + isAddressAvailableByType(customerSet, "HOME"));
        System.out.println("Matching school address found : " + isAddressAvailableByType(customerSet, "SCHOOL"));
    }

    /**
     * APPROVED
     * In this method passed customerSet is handled in null safe manner and result is also null safe, i.e if no matching
     * result then instead of throwing the No Value Present Exception, we will return null
     */
    private static boolean isAddressAvailableByType(Set<Customer> customerSet, String addressType) {
        return Optional
                .ofNullable(customerSet)
                .orElseGet(Collections::emptySet)
                .stream()
                .anyMatch(
                        customer -> Objects.nonNull(customer.getAddress())
                                && addressType.equals(customer.getAddress().getAddressType()));
    }
}
