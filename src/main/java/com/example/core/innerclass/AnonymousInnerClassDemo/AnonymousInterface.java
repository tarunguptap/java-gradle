package com.example.core.innerclass.AnonymousInnerClassDemo;

public class AnonymousInterface {
	public static void main(String args[]){  
		Eatable e=new Eatable(){
			public void eat(){
				System.out.println("nice fruits");
			}  
		};  
		e.eat();  
	 }  
}

interface Eatable{  
	 void eat();  
} 