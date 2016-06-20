package com.example.hibernate.annotation.mapping.ManyToMany.set.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="ManyToMany_Employee") 
public class Employee 
{
	@Id
	@GeneratedValue
	@Column(name = "EMP_ID") 
	public int id;
	@Column(name = "NAME", nullable = false, length = 100)
	public String name;
	@ManyToMany(cascade = CascadeType.ALL) 
	@JoinTable(name = "EMP_ADDR", joinColumns = { @JoinColumn(name = "EMP_ID_NAME") }, inverseJoinColumns = { @JoinColumn(name = "EMPADDR_ID_NAME") })
	public Set<EmployeeAddress> empaddr = new HashSet<EmployeeAddress>(0);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
