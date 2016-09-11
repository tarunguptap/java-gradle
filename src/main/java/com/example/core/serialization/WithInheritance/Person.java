package com.example.core.serialization.WithInheritance;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;  
	String name;  
	Person(int id, String name) {  
	  this.id = id;  
	  this.name = name;  
	}  

}
