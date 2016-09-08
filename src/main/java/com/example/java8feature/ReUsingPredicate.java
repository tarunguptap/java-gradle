package com.example.java8feature;

import java.util.function.Predicate;

import org.apache.commons.lang.StringUtils;

import com.example.java8feature.dto.Customer;
import com.example.java8feature.dto.Employee;
import com.example.java8feature.dto.InitializerHelper;

public class ReUsingPredicate {
	public static void main(String[] args) {
		
		Customer customer = InitializerHelper.getCustomerWithEmploeeDetail();
		/**
         *  Re-Using Predicate
         */
        Predicate<Employee> empPredicate = employee -> StringUtils.equals(employee.getType(), "ADMIN");
        
        // any match
        boolean adminEmpFlag = customer.getEmployees().stream().anyMatch(empPredicate);
        System.out.println("any match predicate "+adminEmpFlag);
        
        //all match
        adminEmpFlag = customer.getEmployees().stream().allMatch(empPredicate);
        System.out.println("all match predicate "+adminEmpFlag);
        
        //noneMatch
        adminEmpFlag = customer.getEmployees().stream().noneMatch(empPredicate);
        System.out.println("none match predicate "+adminEmpFlag);
	}
}
