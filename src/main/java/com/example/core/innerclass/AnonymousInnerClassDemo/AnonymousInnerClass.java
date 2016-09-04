package com.example.core.innerclass.AnonymousInnerClassDemo;

abstract class OuterClass {
	
	public abstract void mymethod();
	
}

class AnonymousInnerClass {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass(){

			@Override
			public void mymethod() {
				System.out.println("This is an example of anonymous inner class");
			}
			
		};
		outerClass.mymethod();
	}
}
