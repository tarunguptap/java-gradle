package com.example.hibernate.annotation.mapping.OneToMany.setjointable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone {

	@Id
	@GeneratedValue( generator="increment" )
	@org.hibernate.annotations.GenericGenerator( name = "increment", strategy = "increment" )
	@Column(name = "PHONE_ID")
	private long phoneId;
	@Column(name = "PHONE_TYPE", nullable = false, length=10)
	private String phoneType;
	@Column(name = "PHONE_NUMBER", nullable = false, length=15)
	private String phoneNumber;

	public Phone() {
	}

	public Phone(String phoneType, String phoneNumber) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	}
	
	
	public long getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	
	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
