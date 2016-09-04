package com.example.core.innerclass.NestedInterfaceAndClass.NestedInterface.InInterface;

/**
 * An interface i.e. declared within another interface or class is known as nested interface. 
 * The nested interfaces are used to group related interfaces so that they can be easy to maintain. 
 * The nested interface must be referred by the outer interface or class. It can't be accessed directly.
 * 
 * Nested interface must be public if it is declared inside the interface but it can have any access 
 * modifier if declared within the class.
 * Nested interfaces are declared static implicitly.
 * 
 */

public interface Parent {
	void p();
	interface Child{
		void c();
	}

}
