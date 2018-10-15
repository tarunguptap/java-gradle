package com.example.java8feature;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.java8feature.dto.Address;
import com.example.java8feature.dto.ContactDetail;
import com.example.java8feature.dto.Customer;

public class CheckObjectExistenceBasedOnCondition {

    public static void main(String[] args) {
        Set<Customer> customerSet = Customer.getCustomerSet();
        System.out.println("Matching home address found : " + isAddressAvailableByType(customerSet, "HOME"));
        System.out.println("Matching school address found : " + isAddressAvailableByType(customerSet, "SCHOOL"));

        System.out.println("Customer HOME Mobile Number is :: "
                + getCustomerMobFromAddress(getCustomer().getContactDetails(), "HOME"));

        System.out.println("Customer College Mobile Number is :: "
                + getCustomerMobFromAddress(getCustomer().getContactDetails(), "COLLEGE"));

        System.out.println("Customer Home Name is :: "
                + getCustomerNameFromAddress(getCustomer().getContactDetails(), "HOME"));

    }

    private static Customer getCustomer() {
        Customer customer1 = new Customer(1L, "arun1");
        Address address1 = new Address(1L, "arun1", "OFFICE");
        customer1.setContactDetails(getConstactDetailSet());
        customer1.setAddress(address1);
        return customer1;
    }

    private static Set<ContactDetail> getConstactDetailSet() {
        ContactDetail contactDeatil1 = new ContactDetail(1L, "1", "123", "OFFICE");
        ContactDetail contactDeatil2 = new ContactDetail(2L, "2", "456", "HOME");
        ContactDetail contactDeatil3 = new ContactDetail(3L, "3", "789", "PERSONAL");
        Address address1 = new Address(1L, "arun1", "OFFICE");
        Address address2 = new Address(2L, "arun2", "HOME");
        Address address3 = new Address(3L, "arun3", "PERSONAL");
        contactDeatil1.setAddress(address1);
        contactDeatil2.setAddress(address2);
        contactDeatil3.setAddress(address3);
        Set<ContactDetail> contactDeatils1 = new HashSet<>();
        contactDeatils1.add(contactDeatil1);
        contactDeatils1.add(contactDeatil2);
        contactDeatils1.add(contactDeatil3);
        return contactDeatils1;
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

    private static String getCustomerMobFromAddress(Set<ContactDetail> constactDetails, String contactType) {
        return Optional
                .ofNullable(constactDetails)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(constactDetail -> Objects.nonNull(constactDetail)
                        && Objects.nonNull(constactDetail.getContacttype())
                        && contactType.equalsIgnoreCase(constactDetail.getContacttype())).findFirst()
                .map(ContactDetail::getMobnum).orElse(null);
    }

    private static String getCustomerNameFromAddress(Set<ContactDetail> constactDetails, String contactType) {
        return Optional
                .ofNullable(constactDetails)
                .orElseGet(Collections::emptySet)
                .stream()
                .filter(constactDetail -> Objects.nonNull(constactDetail)
                        && Objects.nonNull(constactDetail.getContacttype())
                        && contactType.equalsIgnoreCase(constactDetail.getContacttype())).findFirst()
                .map(ContactDetail::getAddress).map(Address::getFirstName).orElse(null);
    }
}
