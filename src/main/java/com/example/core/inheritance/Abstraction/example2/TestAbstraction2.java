package com.example.core.inheritance.Abstraction.example2;

/**
 * In this example, A is an interface having 4 methods
 * B is an abstract class which implements interface A, so it doesn't require to implement interface methods
 * But in this example, abstract class B implements only 1 method
 * Class M is another class which extends class B. Since M is not a abstract class, so it needs to implement
 * remaining methods of interface A which are not implemented by abstract class B.
 *
 */

public class TestAbstraction2{  
	public static void main(String args[]){  
		A a=new M();  
		a.a();  
		a.b();  
		a.c();  
		a.d();   
	}  
}  