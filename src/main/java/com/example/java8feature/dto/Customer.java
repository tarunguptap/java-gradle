package com.example.java8feature.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Customer {
    private Long id;
    private String userId;
    private String firstname;
    private String lastname;
    private String mobnum;
    private String offphone;
    private Date createddate;
    private List<Employee> employees;
    private Map<String, Employee> employeesMap;

    public Customer() {

    }

    public Customer(Long id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public Customer(Long id, String userId, String firstname, String lastname, Date createddate,
            String mobnum, String offphone) {
        this.offphone = offphone;
        this.mobnum = mobnum;
        this.id = id;
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createddate = createddate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobnum() {
        return mobnum;
    }

    public void setMobnum(String mobnum) {
        this.mobnum = mobnum;
    }

    public String getOffphone() {
        return offphone;
    }

    public void setOffphone(String offphone) {
        this.offphone = offphone;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Employee> getEmployeesMap() {
        return employeesMap;
    }

    public void setEmployeesMap(Map<String, Employee> employeesMap) {
        this.employeesMap = employeesMap;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(" Id : " + id).append(" | userId : " + userId)
                .append(" | firstname : " + firstname).append(" | lastname : " + lastname).toString();
    }

    @Override
    public boolean equals(Object Obj) {

        if (!(Obj instanceof Customer))
            return false;

        Customer imei = (Customer) Obj;
        return new EqualsBuilder().append(imei.getUserId(), this.getUserId())
                .append(imei.getFirstname(), this.getFirstname()).append(imei.getLastname(), this.getLastname())
                .isEquals();
    }//

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.userId).toHashCode();
    }
}
