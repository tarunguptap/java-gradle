package com.example.java8feature.filterobjectbyproperty;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.java8feature.dto.Customer;
import com.example.java8feature.dto.Employee;
import com.example.java8feature.dto.InitializerHelper;

public class IntersactionOfTwoObjectListBasedOnCommonProperty {
    Map<Customer, String> testmap = new HashMap();

    public static void main(String[] args) {
        Customer customer = InitializerHelper.getCustomerWithEmployeeList();

        List<Employee> employeeList = InitializerHelper.getEmployeeList();

        Employee customerEmployee = Optional.ofNullable(customer.getEmployees()).orElse(Collections.emptyList())
                .stream().flatMap(ce -> employeeList.stream().filter(e -> ce.getType().equals(e.getType())))
                .findFirst().orElse(null);
        System.out.println(customerEmployee.getType());
        /* Employee customerEmployee = Optional
                 .ofNullable(customer.getEmployees())
                 .orElse(Collections.emptyList())
                 .stream()
                 .filter(ce -> ce.getType().equals(
                         employeeList.stream().filter(e -> e.getType().equals(ce.getType())).map(Employee::getType)
                                 .findFirst())).findFirst().orElse(null);
         System.out.println(customerEmployee.getType());*/
    }
}
