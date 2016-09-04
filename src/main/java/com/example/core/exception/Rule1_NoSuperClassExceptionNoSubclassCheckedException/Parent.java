package com.example.core.exception.Rule1_NoSuperClassExceptionNoSubclassCheckedException;

import java.io.IOException;

/**
 * Rule 1 : If the superclass method does not declare an exception, subclass overridden method cannot declare the 
 * checked exception. 
 */
public class Parent {
	void msg(){System.out.println("parent");} 
	
	void display(){System.out.println("parent");}
}

class Child extends Parent{  
	  void msg()throws IOException{  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  void display()throws Exception{  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  public static void main(String args[]){  
	   Parent p=new Child();  
	   p.msg();  
	  }  
	}
// Output:Compile Time Error