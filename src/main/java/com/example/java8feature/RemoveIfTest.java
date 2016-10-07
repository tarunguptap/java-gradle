package com.example.java8feature;

import org.apache.commons.lang.StringUtils;

import com.example.java8feature.dto.Customer;
import com.example.java8feature.dto.InitializerHelper;

public class RemoveIfTest {
    public static void main(String[] args) {
        Customer customer = InitializerHelper.getCustomerWithEmploeeDetail();
        System.out.println(customer.getEmployees());

        customer.getEmployees().removeIf(employee -> employee.getType().compareTo("ADMIN") == 0);
        System.out.println(customer.getEmployees());

        customer.getEmployees().removeIf(employee -> StringUtils.equals(employee.getType(), "ADMIN"));
        System.out.println(customer.getEmployees());

    }
}
