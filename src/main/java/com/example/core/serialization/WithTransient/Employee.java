package com.example.core.serialization.WithTransient;

public class Employee implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
   public Long id;
   public String name;
   public transient int SSN;
   
   public Employee() {
	   
   }
   
   public Employee(Long id, String name, int SSN) {
	   this.id=id;
	   this.name = name;
	   this.SSN=SSN;
   }
   
   @Override
   public String toString() {
	   return "id : "+id+" name : "+name + " SSN : "+ SSN;
   }
}