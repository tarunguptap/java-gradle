package com.example.core.interfaces.NestedInterface.InInterface;

public class MainClass {
	public static void main(String[] args) {
		Parent.Child child=new ClassImplChildInterface();
		child.c();
		
		Parent parent=new ClassImplParentInterface();
		parent.p();
	}

}
