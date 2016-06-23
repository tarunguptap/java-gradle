package com.example.hibernate.xml.mapping.OneToMany.set.example1.model;

import java.util.HashSet;
import java.util.Set;

import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.PersistentEntity;


public class Employee extends PersistentEntity
{
	public String name;
	public Set<EmployeeAddress> empaddr = new HashSet<EmployeeAddress>();

		public Employee() {
		}
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<EmployeeAddress> getEmpaddr() {
		return empaddr;
	}
	public void setEmpaddr(Set<EmployeeAddress> empaddr) {
		this.empaddr = empaddr;
	}
	public void addEmpAddr(EmployeeAddress employeeAddress) {
		employeeAddress.setEid(this);
		this.empaddr.add(employeeAddress);
	}
	
}
