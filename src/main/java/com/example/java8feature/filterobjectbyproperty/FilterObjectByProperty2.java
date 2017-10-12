package com.example.java8feature.filterobjectbyproperty;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.java8feature.dto.Address;
import com.example.java8feature.dto.Customer;

public class FilterObjectByProperty2 {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();

        Address validAddress = filterCustomerByContactTypeToGetAddress(customerSet, "HOME");
        System.out.println(validAddress.getFirstName());

        System.out.println("Customer Name : " + getFirstNameFromCustomerAddress(customerSet, "HOME"));

        Address emptyAddressWithNullSafeSet = filterCustomerByContactTypeToGetAddressNullSafe(null, "HOME");
        System.out.println("null safe : " + Objects.isNull(emptyAddressWithNullSafeSet));

        // Throws No value present
        Address invalidAddress = filterCustomerByContactTypeToGetAddress(customerSet, "DUMMY");
        System.out.println(Objects.isNull(invalidAddress));

        // Null pointer Exception
        Address validAddressWithNullSet = filterCustomerByContactTypeToGetAddress(null, "HOME");
        System.out.println(validAddressWithNullSet.getFirstName());

    }

    /**
     * APPROVED
     * In this method passed customerSet is handled in null safe manner and result is also null safe, i.e if no matching
     * result then instead of throwing the No Value Present Exception, we will return null
     */
    private static Address filterCustomerByContactTypeToGetAddressNullSafe(Set<Customer> customerSet, String addressType) {
        return Optional
                .ofNullable(customerSet)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(customer -> Objects.nonNull(customer.getAddress())
                        && addressType.equals(customer.getAddress().getAddressType())).findFirst()
                .map(Customer::getAddress).orElse(null);
    }

    /**
     * This method excepts both arguments customerSet & addressType should be valid and non null
     */
    private static Address filterCustomerByContactTypeToGetAddress(Set<Customer> customerSet, String addressType) {
        return customerSet
                .stream()
                .filter(customer -> Objects.nonNull(customer.getAddress())
                        && addressType.equals(customer.getAddress().getAddressType())).findFirst()
                .map(Customer::getAddress).get();

    }

    /**
     * In this method customerSet is handled to be null safe where as second argument addressType should be valid and
     * non null
     */
    private static String getFirstNameFromCustomerAddress(Set<Customer> customerSet, String addressType) {
        return Optional
                .ofNullable(customerSet)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(customer -> Objects.nonNull(customer.getAddress())
                        && addressType.equals(customer.getAddress().getAddressType())).findFirst()
                .map(customer -> customer.getAddress().getFirstName()).get();
    }
}
