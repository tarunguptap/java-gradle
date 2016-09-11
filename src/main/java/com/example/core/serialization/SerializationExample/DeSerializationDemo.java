package com.example.core.serialization.SerializationExample;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerializationDemo {
	public static void main(String[] args) throws Exception {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/employee.ser"));  
		Employee s=(Employee)in.readObject();  
		System.out.println(s.id+" "+s.name);  
		in.close();  
	}
}
