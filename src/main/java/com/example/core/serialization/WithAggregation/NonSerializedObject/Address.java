package com.example.core.serialization.WithAggregation.NonSerializedObject;

public class Address {
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
