package com.example.core.string;

public class StringConstantPool {

		public static void main(String[] args) {
		String s = "prasad";
		String s2 = "prasad";
		String s3 = new String("prasad"); 
	 
		System.out.println(s.equals(s2));
		System.out.println(s == s2);
		System.out.println(s.equals(s3));
		System.out.println(s == s3);
		
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		}
}
//Output is :
//true
//true
//true
//false