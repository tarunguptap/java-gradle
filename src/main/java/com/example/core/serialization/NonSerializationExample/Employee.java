package com.example.core.serialization.NonSerializationExample;

public class Employee
{
   public Long id;
   public String name;
   public String address;
   public transient int SSN;
   public int number;
   
   public Employee() {
	   
   }
   
   public Employee(Long id, String name) {
	   this.id=id;
	   this.name = name;
   }
}