package com.example.java8feature.filterobjectbyproperty;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.example.java8feature.dto.Customer;

public class FilterObjectByProperty1 {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();

        // Java 7
        Customer traditionalCust = filterByPredicate(customerSet, "DUMMY");
        System.out.println(Objects.isNull(traditionalCust));

        // Java 8
        Optional<Customer> customerOptional = filterCustomerByContactType(customerSet, "PERSONAL");
        if (customerOptional.isPresent()) {
            System.out.println(customerOptional.get().getFirstname());
        }

    }

    private static Optional<Customer> filterCustomerByContactType(Set<Customer> customerSet, String addressType) {
        return customerSet
                .stream()
                .filter(customer -> Objects.nonNull(customer.getAddress())
                        && addressType.equals(customer.getAddress().getAddressType())).findFirst();
    }

    private static Customer filterByPredicate(Set<Customer> customerSet, String addressType) {
        return (Customer) CollectionUtils.find(customerSet, new Predicate() {
            @Override
            public boolean evaluate(Object obj) {
                Customer customer = (Customer) obj;
                if (Objects.isNull(customer.getAddress())) {
                    return false;
                } else {
                    return addressType.equals(customer.getAddress().getAddressType());
                }
            }
        });
    }
}
