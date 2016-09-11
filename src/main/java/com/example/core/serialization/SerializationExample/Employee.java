package com.example.core.serialization.SerializationExample;

public class Employee implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
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
   
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name + " " + address);
   }
}