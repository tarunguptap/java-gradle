package com.example.core.comparable;

import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

//company
public class Employee implements Comparable<Employee> {
    private Long id = new Long(-1);
    private String name;
    private SortedSet<EmployeeIdentity> employeeIdentities = new TreeSet<EmployeeIdentity>(new EmployeeIdentityComparator());

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the companyCategories
     */
    public SortedSet<EmployeeIdentity> getEmployeeIdentities() {
        return employeeIdentities;
    }

    /**
     * @param employeeIdentities
     *            the employeeIdentities to set
     */
    public void setEmployeeIdentities(SortedSet<EmployeeIdentity> employeeIdentities) {
        this.employeeIdentities = employeeIdentities;
    }

    public SortedSet<Identity> getIdentities() {
        SortedSet<Identity> identities = new TreeSet<Identity>();
        for (EmployeeIdentity employeeIdentity : employeeIdentities) {
            identities.add(employeeIdentity.getIdentity());
        }
        return identities;
    }

    @Override
    public int compareTo(Employee company) {
        return StringUtils.lowerCase(this.name).compareTo(StringUtils.lowerCase(company.getName()));
    }
}
