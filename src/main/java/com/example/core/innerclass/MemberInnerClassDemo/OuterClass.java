package com.example.core.innerclass.MemberInnerClassDemo;

/*
 * It is a class created with in the class.
 */
public class OuterClass {
	private int x =1;
	
	private void display() {
		System.out.println("value of x is : "+x);
	}
	
	private class MemberInnerClass {
		// Access outer class data members with in inner 
		private void displayInner() {
			++x;
			System.out.println("value of x in inner class is : "+x);
		}
		
	}
	
	//Accessing he inner class from the method within
   void display_Inner(){
	   MemberInnerClass inner = new MemberInnerClass();
      inner.displayInner();
   }
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		OuterClass.MemberInnerClass inner = outer.new MemberInnerClass(); 
		outer.display();
		inner.displayInner();
		
		outer.display_Inner();
	}
}
