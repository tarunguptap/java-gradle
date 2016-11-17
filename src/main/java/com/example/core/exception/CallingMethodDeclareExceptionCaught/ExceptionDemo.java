package com.example.core.exception.CallingMethodDeclareExceptionCaught;

import java.io.IOException;

public class ExceptionDemo {
	void method()throws IOException{  
	  throw new IOException("device error");  
	 } 
	
	public static void main(String[] args) {
		ExceptionDemo exDemo = new ExceptionDemo();
		// un comment below -Case : if we don't catch or throw exception - Compile Error 
//		exDemo.method();
		
		// Case : if we catch or throw exception
		try {
			exDemo.method();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
