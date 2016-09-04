package com.example.core.string;

/**
 * This class is immutable because:
 * The instance variable of the class is final i.e. we cannot change the value of it after creating an object.
 * The instance variable of the class is final i.e. we cannot change the value of it after creating an object.
 * There is no setter methods i.e. we have no option to change the value of the instance variable.
 */

public class CustomImmutableClass {
	
	final String pancardNumber;  
	
	public CustomImmutableClass(String pancardNumber){  
		this.pancardNumber=pancardNumber;  
	} 
	
	public String getPancardNumber(){  
		return pancardNumber;  
	}
	
	public static void main(String[] args) {
		CustomImmutableClass cic =  new CustomImmutableClass("tarun");
		System.out.println(cic.hashCode());
		cic =  new CustomImmutableClass("tarun1");
		System.out.println(cic.hashCode());
	}
}


