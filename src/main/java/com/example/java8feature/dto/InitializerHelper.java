package com.example.java8feature.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InitializerHelper {
    public static List<Customer> getCustomerList() {
        Customer customer1 = new Customer(1L, "arun1");
        Customer customer2 = new Customer(2L, "arun2");
        Customer customer3 = new Customer(3L, "arun3");
        Customer customer4 = new Customer(4L, "arun4");
        Customer customer5 = new Customer(5L, "arun5");
        Customer customer6 = new Customer(6L, "arun6");
        return Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6);
    }
    
    public static Map<Long, Customer> getCustomerMap() {
        return InitializerHelper.getCustomerList().stream().collect(Collectors.toMap(x -> x.getId(), Function.identity()));
    }
    
    public static Customer getCustomerWithEmploeeDetail() {
        Customer customer = new Customer(1L, "arun1");
        customer.setEmployees(getEmployeeList());
        return customer;
    }
    
    public static List<Employee> getEmployeeList() {
        
        Employee employee1 = new Employee(1L, "emp1", "ADMIN");
        Employee employee2 = new Employee(1L, "emp2", "FINANCE");
        Employee employee3 = new Employee(1L, "emp3", "SECURITY");
        Employee employee4 = new Employee(1L, "emp4", "DEV");
        Employee employee5 = new Employee(1L, "emp5", "ANONYMOUS", false);
        return Arrays.asList(employee1, employee2, employee3, employee4, employee5);
    }
    
    public static Map<String, Employee> getEmployeeMap() {
        return InitializerHelper.getEmployeeList().stream().collect(Collectors.toMap(x -> x.getType(), Function.identity()));
    }
}
