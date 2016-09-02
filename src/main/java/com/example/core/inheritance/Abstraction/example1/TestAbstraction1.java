package com.example.core.inheritance.Abstraction.example1;

/**
 * Shape is the abstract class, its implementation is provided by the Rectangle and Circle classes. Mostly, 
 * we don't know about the implementation class (i.e. hidden to the end user) 
 * and object of the implementation class is provided by the factory method.
 * 
 * In this example, if you create the instance of Rectangle class, draw() method of Rectangle class will be invoked.
 */

class TestAbstraction1{  
	public static void main(String args[]){  
		Shape s=new Circle1();//In real scenario, object is provided through method e.g. getShape() method  
		s.draw();  
	}  
}  