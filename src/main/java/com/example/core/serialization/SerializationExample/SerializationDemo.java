package com.example.core.serialization.SerializationExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) throws Exception {
		Employee e1 = new Employee(175L, "arun");
		FileOutputStream fout=new FileOutputStream("E:/employee.ser");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  
		out.writeObject(e1);  
		out.flush();
		out.close();
		System.out.println("success");  
	}
}
