package com.example.core.exception.Rule2_NoSuperClassExceptionSubclassUnCheckedException;


/**
 * Rule 1 : If the superclass method does not declare an exception, subclass overridden method 
 * cannot declare the checked exception but can declare unchecked exception. 
 *  
 */
public class Parent {
	void msg(){System.out.println("parent");} 
	
	void display(){System.out.println("parent");}
}

class Child extends Parent{  
	  void msg()throws NullPointerException{  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  void display()throws ArithmeticException{  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  public static void main(String args[]){  
	   Parent p=new Child();  
	   p.msg();  
	  }  
	}
// Output:Compile Time Error