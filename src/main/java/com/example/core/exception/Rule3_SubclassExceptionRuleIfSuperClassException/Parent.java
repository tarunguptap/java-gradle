package com.example.core.exception.Rule3_SubclassExceptionRuleIfSuperClassException;


/**
 * Rule 3a. If the Parent class method declares an exception, Child class overridden method can declare same exception
 * Rule 3b. If the Parent class method declares an exception, Child class overridden method can declare no exception
 * Rule 3c. If the Parent class method declares an exception, Child class overridden method can declare subclass 
 * 			exception of Parent class exception
 * Rule 3d. If the Parent class method declares an exception, Child class overridden method can't declare superclass 
 * 			exception of Parent class exception
 */
public class Parent {
	// Rule 3a example
	void msg() throws NullPointerException {System.out.println("parent");} 
	
	// Rule 3b example
	void display()  throws NullPointerException {System.out.println("parent");}
	
	// Rule 3c example
	void print()  throws Exception {System.out.println("parent");}
	
	// Rule 3d example
	void read()  throws NullPointerException {System.out.println("parent");}
}

class Child extends Parent{  
	  void msg()throws NullPointerException{  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  void display() {  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  void print() throws NullPointerException {  
	    System.out.println("TestExceptionChild");  
	  }
	  
	  //uncomment below
	  /*void read() throws Exception {  
	    System.out.println("TestExceptionChild");  
	  }*/
	  
	  public static void main(String args[]){  
	   Parent p=new Child();  
	   p.msg();  
	  }  
	}
// Output:Compile Time Error