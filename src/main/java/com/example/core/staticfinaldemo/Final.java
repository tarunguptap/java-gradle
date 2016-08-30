package com.example.core.staticfinaldemo;

public class Final {
	final int a;
	Final(){
		a=10;
	}
	static final int b;
	static{b=6;}
	public static void main(String[] args) {
		final int y;
		System.out.println(b);  //6
//		System.out.println(a);    compile time error
		Final f1 = new Final();
		System.out.println(f1.a);
	}
}
