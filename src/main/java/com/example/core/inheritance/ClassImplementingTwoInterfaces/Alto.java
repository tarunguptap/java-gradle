package com.example.core.inheritance.ClassImplementingTwoInterfaces;

public class Alto implements CarInterface, FourWheelerInterface{

	@Override
	public void displayEngine() {
		System.out.println("Alto display");
		
	}

	@Override
	public void displayWeight() {
		System.out.println("Alto Weight is NA");
		
	}

}
