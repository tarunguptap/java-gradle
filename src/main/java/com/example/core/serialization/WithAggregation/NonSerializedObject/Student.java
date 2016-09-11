package com.example.core.serialization.WithAggregation.NonSerializedObject;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;  
	String name;
	Address address;//HAS-A 
	Student(int id, String name, Address address) {  
	  this.id = id;  
	  this.name = name;  
	  this.address= address;
	}  
	@Override
	public String toString() {
		return "id: "+ id + " :name : " + name+address.toString();
	}
	
}
