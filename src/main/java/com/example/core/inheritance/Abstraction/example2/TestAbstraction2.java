package com.example.core.inheritance.Abstraction.example2;

/**
 * In this example, A is an interface having 4 methods
 * B is an abstract class which implements interface A, so it doesn't require to implement interface methods
 * But in this example, abstract class B implements only 1 method
 * Class M is another class which extends class B. Since M is not a abstract class, so it needs to implement
 * remaining methods of interface A which are not implemented by abstract class B.
 *
 * Abstraction hides the implementation details whereas encapsulation wraps code and data into a single unit.
 * 
 * A class that is declared as abstract is known as abstract class. 
 * It needs to be extended and its method implemented. It cannot be instantiated.
 * 
 * we can't use abstract and final both with a method, because abstract method needs to 
 * be overridden whereas you can't override final method. 
 * 
 *  Interface also represents IS-A relationship.
 *  The interface in java is a mechanism to achieve fully abstraction
 *  It can be used to achieve loose coupling.
 *  The java compiler adds public and abstract keywords before the interface method and public, 
 *  static and final keywords before data members.
 *  
 *  An interface that have no member is known as marker or tagged interface. 
 *  For example: Serializable, Cloneable, Remote etc. They are used to provide some essential information 
 *  to the JVM so that JVM may perform some useful operation.
 */

public class TestAbstraction2{  
	public static void main(String args[]){ 
		//B b = new B();  Can't instantiate
		
		A a=new M();  
		a.a();  
		a.b();  
		a.c();  
		a.d();   
	}  
}  