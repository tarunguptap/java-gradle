package com.example.core.inheritance.RunTimePolymorphism;

/**
 * Runtime polymorphism or dynamic method dispatch is a process in which a call to an overridden 
 * method is resolved at runtime rather than at compile-time.
 * 
 * In this process, an overridden method is called through the reference variable of a super class. 
 * The determination of the method to be called is based on the object being referred to by the reference variable.
 * 
 * Runtime polymorphism cannot be acheived by data members
 * 
 * In case of static binding type of object is determined at compile
 */



public class MainClass_RuntimePolymorphism {
	public static void main(String[] args) {
		ParentClass obj=new SubClass();
		obj.display();
	}

}
