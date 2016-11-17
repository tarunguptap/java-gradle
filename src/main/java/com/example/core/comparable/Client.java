package com.example.core.comparable;

import java.util.SortedSet;
import java.util.TreeSet;

public class Client {
    public static final long OBJECT_ID = 1L;
    public static void main(String[] args) {
        // This doesn't gives the employee identity object 
        Employee employee = getEmployee(Identity.Code.TEST_CODE);
        for (Identity identity : employee.getIdentities()) {
            System.out.println(identity.getCode());
        }

        // This method doesn't give any exception, we need to figure out in next method what is breaking
        Employee employee2 = getEmployeeByIdentity1(Identity.Code.TEST_CODE);
        for (Identity identity : employee2.getIdentities()) {
            System.out.println(identity.getCode());
        }

        // This method gives the Exception :
        /**
         * Exception in thread "main" java.lang.ClassCastException: com.example.core.comparable.employeeidentity cannot
         * be cast to java.lang.Comparable
         */
        Employee employee1 = getEmployeeByIdentity(Identity.Code.TEST_CODE);
        for (Identity identity : employee1.getIdentities()) {
            System.out.println(identity.getCode());
        }



    }

    private static Employee getEmployeeByIdentity1(Identity.Code identityCode) {
        Employee employee = new Employee();
        employee.setId(OBJECT_ID);
        Identity identity = new Identity();
        identity.setId(OBJECT_ID);
        identity.setCode(identityCode);
        employee.getEmployeeIdentities().add(new EmployeeIdentity(identity, employee));
        return employee;
    }

    private static Employee getEmployeeByIdentity(Identity.Code identityCode) {
        Employee employee = new Employee();
        employee.setId(OBJECT_ID);
        Identity identity = new Identity();
        identity.setId(OBJECT_ID);
        identity.setCode(identityCode);
        EmployeeIdentity employeeIdentity = new EmployeeIdentity(identity, employee);
        employeeIdentity.setId(OBJECT_ID);
        SortedSet<EmployeeIdentity> employeeIdentitySet = new TreeSet<EmployeeIdentity>();
        employeeIdentitySet.add(employeeIdentity);
        employee.setEmployeeIdentities(employeeIdentitySet);
        return employee;
    }

    private static Employee getEmployee(Identity.Code identityCode) {
        Employee employee = new Employee() {
            // mocking this method since we are not testing its functionality here
            @Override
            public SortedSet<EmployeeIdentity> getEmployeeIdentities() {
                Identity identity = new Identity();
                identity.setId(OBJECT_ID);
                identity.setCode(identityCode);
                EmployeeIdentity employeeIdentity = new EmployeeIdentity(identity, this);
                employeeIdentity.setId(OBJECT_ID);
                SortedSet<EmployeeIdentity> employeeCategories = new TreeSet<EmployeeIdentity>();
                employeeCategories.add(employeeIdentity);
                return employeeCategories;
            }
        };
        employee.setId(OBJECT_ID);
        return employee;
    }
}
