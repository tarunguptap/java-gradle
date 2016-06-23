package com.example.hibernate.xml.mapping.OneToMany.set.example1.model;

import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.PersistentEntity;


public class EmployeeAddress extends PersistentEntity
{
	public Employee eid;
	public String address;
	public String city;
  public Contact contact;

  public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Employee getEid() {
		return eid;
	}
	public void setEid(Employee eid) {
		this.eid = eid;
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
	public EmployeeAddress(String address, String city, Contact contact) {
		this.address = address;
		this.city = city;
		this.contact=contact;
	}
	public EmployeeAddress(){
		
	}
}
