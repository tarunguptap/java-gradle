package com.example.hibernate.annotation.mapping.ManyToMany.set.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ManyToMany_EMPADDR") 
public class EmployeeAddress 
{
	@Id
	@GeneratedValue
	@Column(name = "EMPADDR_ID")
	public int id;
	@Column(name = "ADDRESS", nullable = false, length = 100)
	public String address;
	@Column(name = "CITY", nullable = false, length = 100)
	public String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
