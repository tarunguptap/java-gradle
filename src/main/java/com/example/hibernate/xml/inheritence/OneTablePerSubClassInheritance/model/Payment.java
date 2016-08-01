package com.example.hibernate.xml.inheritence.OneTablePerSubClassInheritance.model;

import com.example.hibernate.xml.inheritence.OneTablePerSubClassInheritance.model.PersistentEntity;



public class Payment extends PersistentEntity{

	private static final long serialVersionUID = 1L;
	private double amount;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	 

}