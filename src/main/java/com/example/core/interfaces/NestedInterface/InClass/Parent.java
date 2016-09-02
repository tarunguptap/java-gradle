package com.example.core.interfaces.NestedInterface.InClass;

/**
 * An interface i.e. declared within another interface or class is known as nested interface. 
 * The nested interfaces are used to group related interfaces so that they can be easy to maintain. 
 * The nested interface must be referred by the outer interface or class. It can't be accessed directly.
 * 
 * Nested interface must be public if it is declared inside the interface but it can have any access 
 * modifier if declared within the class.
 * Nested interfaces are declared static implicitely.
 * 
 */

public class Parent {
	interface Message{  
		   void msg();  
		  } 

}
