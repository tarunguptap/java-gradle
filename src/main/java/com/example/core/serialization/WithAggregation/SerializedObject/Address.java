package com.example.core.serialization.WithAggregation.SerializedObject;

import java.io.Serializable;

public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String addressLine, city, state;  
	
	public Address(String addressLine, String city, String state) {  
	  this.state=state;  
	  this.city=city;
	  this.addressLine=addressLine;
	}  
	@Override
	public String toString() {
		return "addressLine: "+ addressLine + " :city : " + city+" :state : "+state;
	}
}
