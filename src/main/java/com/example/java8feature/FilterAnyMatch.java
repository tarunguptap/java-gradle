package com.example.java8feature;

import org.apache.commons.lang.StringUtils;

import com.example.java8feature.dto.Customer;
import com.example.java8feature.dto.Employee;
import com.example.java8feature.dto.InitializerHelper;

public class FilterAnyMatch {
    public static void main(String[] args) {
          //With java7 or earlier
            boolean isAdminEmployee = Boolean.FALSE;
            Customer customer = InitializerHelper.getCustomerWithEmploeeDetail();
            for (Employee employee : customer.getEmployees()) {
                if (StringUtils.equals(employee.getType(), "ADMIN")) {
                    isAdminEmployee = Boolean.TRUE;
                    break;
                }
            }
            System.out.println("Java 7 "+isAdminEmployee);
            
          //With java8 or earlier
          // Match on List
            isAdminEmployee = customer.getEmployees().stream().anyMatch(employee -> StringUtils.equals(employee.getType(), "ADMIN"));
            System.out.println("Java 8 "+isAdminEmployee);
        
         // Match on Map
         boolean isFinanceEmployee =  InitializerHelper.getEmployeeMap().values().stream().anyMatch(employee -> StringUtils.equals(employee.getType(), "FINANCE"));
         System.out.println("Java 8 "+isFinanceEmployee);
            
    }
}
