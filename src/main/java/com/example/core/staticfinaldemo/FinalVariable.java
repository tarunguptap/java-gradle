package com.example.core.staticfinaldemo;

public class FinalVariable {

	/**
	 * Blank final variable
	 * Blank final variable is a variable which is not initialized while declaration
	 * Blank final variable can be initialized in constructor. If its not initialized in constructor then there will be compile time error.
	 */
	
	/**
	 * Blank static final variable
	 * Blank static final variable is a variable which is not initialized while declaration
	 * Blank static final variable can be initialized in static block only. If its not initialized then there will be compile time error.
	 */
	
	/**
	 * 
	 */
	
	final String finalString;
	static final String staticFinalString;
	
	public FinalVariable() {
		finalString = "testFinalString";
		//staticFinalString = "test";
	}
	
	static{
		staticFinalString = "testStaticFinalString";
	}
	
	public static void main(String[] args) {
		System.out.println("staticFinalString      "+staticFinalString);
		FinalVariable fv = new FinalVariable();
		System.out.println("finalString     "+fv.finalString);
	}
}
