package com.example.core.interfaces.ClassInsideInterface;

/**
 * We can define a class inside the interface
 * If we define a class inside the interface, java compiler creates a static nested class.
 */

public interface Parent {
	void p();
	class A{
		void display() {
			System.out.println("inside static nested class");
		}
	}  

}
