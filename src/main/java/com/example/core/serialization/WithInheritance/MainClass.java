package com.example.core.serialization.WithInheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Java Serialization with Inheritance (IS-A Relationship) : 
 * If a class implements serializable then all its sub classes will also be serializable.
 *
 */
public class MainClass {

	public static void main(String[] args) throws Exception{
		// Serialization
	    Student s1 = new Student(175, "arun", "mca", 200 );
		FileOutputStream fout=new FileOutputStream("E:/inheritence.ser");  
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.close();
        fout.close();
        System.out.printf("Serialized data is saved in E:/inheritence.ser");
      
        // De-Serialization
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/inheritence.ser"));  
        Student s=(Student)in.readObject();  
		System.out.println(s.id+" "+s.name+" "+s.fee+" "+s.course);  
		in.close();  
	}

}
