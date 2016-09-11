package com.example.core.serialization.WithStaticDataMember;

public class Employee implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
   public Long id;
   public String name;
   public static String address = "test address";
   
   public Employee() {
	   
   }
   
   public Employee(Long id, String name, String address) {
	   this.id=id;
	   this.name = name;
	   this.address =  address;
   }
   
   @Override
   public String toString() {
	   return "id : "+id+" name : "+name + " adddress : "+ address;
   }
}