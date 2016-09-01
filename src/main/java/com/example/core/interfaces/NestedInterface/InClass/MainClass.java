package com.example.core.interfaces.NestedInterface.InClass;

public class MainClass {
	
	public static void main(String[] args) {
		Parent.Message message=new ImplClass();//upcasting here  
		message.msg();  
	}

}
