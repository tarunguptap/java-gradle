package com.example.core.innerclass.LocalInnerClass;

public class LocalInnerClass {
	private int data=30;//instance variable  
	
	void display(){
		class local {
			void msg() {
				System.out.println(data);
			}
		}
		local local = new local();
		local.msg();
	}
	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		lic.display();
	}
}
