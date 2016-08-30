package com.example.core.other;

public class MainMethodOverload {

	public static void main(String[] args) {
		
		//System.out.println(a);
		display(2,2);
		//sum(2,2);
		
	}
/*	static void display(int a,int b){
		System.out.println("int int");
	}*/
	
	static void display(char a,char b){
		System.out.println("char char");
	}

	static void display(long a,long b){
		System.out.println("long long");
	}
	
	//main method overloaded
	public static void main(int a) {
		System.out.println("aaaaaaaaaaaaaaa");
		
	}
	
	 static void sum(int a,long b){System.out.println("a method invoked");}  
	 static void sum(long a,int b){System.out.println("b method invoked");}  

}
