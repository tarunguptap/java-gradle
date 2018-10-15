package com.example.java8feature.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private Set<ContactDetail> contactDetails;
    private Address address;

    public Customer() {

    }

    public Customer(Long id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public Customer(Long id, String firstname, List<Employee> employees) {
        this.id = id;
        this.firstname = firstname;
        this.employees = employees;
    }

    public Customer(Long id, String userId, String firstname, String lastname, Date createddate, String mobnum,
            String offphone) {
        this.offphone = offphone;
        this.mobnum = mobnum;
        this.id = id;
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createddate = createddate;
    }

    public Customer(Long id, String userId, String firstname, String lastname, Date createddate,
            Set<ContactDetail> contactDetails, String mobnum, String offphone) {
        this(id, firstname);
        this.offphone = offphone;
        this.mobnum = mobnum;
        this.userId = userId;
        this.lastname = lastname;
        this.createddate = createddate;
        this.contactDetails = contactDetails;
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

    public Set<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Set<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static List<Customer> getCustomerList() {
        ContactDetail contactDeatil1 = new ContactDetail(1L, "1", "123", "OFFICE");
        ContactDetail contactDeatil6 = new ContactDetail(6L, "6", "123", "HOME");
        ContactDetail contactDeatil7 = new ContactDetail(7L, "7", "123", "PERSONAL");
        Set<ContactDetail> contactDeatils1 = new HashSet<>();
        contactDeatils1.add(contactDeatil1);
        Set<ContactDetail> contactDeatils6 = new HashSet<>();
        contactDeatils1.add(contactDeatil6);
        Set<ContactDetail> contactDeatils7 = new HashSet<>();
        contactDeatils1.add(contactDeatil7);

        Address address1 = new Address(1L, "arun1", "OFFICE");
        Address address6 = new Address(6L, "arun6", "HOME");
        Address address7 = new Address(7L, "arun7", "PERSONAL");

        Customer customer1 = new Customer(1L, "arun1");
        customer1.setContactDetails(contactDeatils1);
        customer1.setAddress(address1);
        Customer customer2 = new Customer(2L, "arun2");
        Customer customer3 = new Customer(3L, "arun3");
        Customer customer4 = new Customer(4L, "arun4");
        Customer customer5 = new Customer(5L, "arun5");
        Customer customer6 = new Customer(6L, "arun6");
        customer6.setContactDetails(contactDeatils6);
        customer6.setAddress(address6);
        Customer customer7 = new Customer(7L, "arun7");
        customer7.setContactDetails(contactDeatils7);
        customer7.setAddress(address7);
        return Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6, customer7);
    }

    public static Set<Customer> getCustomerSet() {
        return new HashSet<>(getCustomerList());
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
