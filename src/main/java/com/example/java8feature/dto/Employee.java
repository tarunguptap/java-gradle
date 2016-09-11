package com.example.java8feature.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Employee {
    private Long id;
    private String name;
    private String type;
    private Boolean isValidEmployee = Boolean.TRUE;

    public Employee() {

    }

    public Employee(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type=type;
    }

    public Employee(Long id, String name, String type, Boolean isValidEmployee) {
        this.id = id;
        this.name = name;
        this.type=type;
        this.isValidEmployee = isValidEmployee;   
    }


    public Boolean getIsValidEmployee() {
		return isValidEmployee;
	}

	public void setIsValidEmployee(Boolean isValidEmployee) {
		this.isValidEmployee = isValidEmployee;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(" Id : " + id)
                .append(" | name : " + name).append(" | type : " + type).toString();
    }

    @Override
    public boolean equals(Object Obj) {

        if (!(Obj instanceof Customer))
            return false;

        Employee employee = (Employee) Obj;
        return new EqualsBuilder().append(employee.getId(), this.getId())
                .append(employee.getName(), this.getName()).append(employee.getType(), this.getType())
                .isEquals();
    }//

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.name).append(this.type).toHashCode();
    }
}
