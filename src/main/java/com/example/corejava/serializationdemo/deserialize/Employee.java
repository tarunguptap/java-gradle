package com.example.corejava.serializationdemo.deserialize;

public class Employee
{
   public String name;
   public String address;
   public transient int SSN;
   public int number;
   
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name + " " + address);
   }
}