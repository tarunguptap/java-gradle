package com.example.core.serialization.WithAggregation.NonSerializedObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Java Serialization with Aggregation (HAS-A Relationship) :
 * If a class has a reference of another class, all the references must be Serializable otherwise serialization process 
 * will not be performed. In such case, NotSerializableException is thrown at runtime.
 * 
 * In this example, address class is non serialized so we will get run time exception
 *
 */
public class MainClass {

	public static void main(String[] args) throws Exception{
		// Serialization
		Address a = new Address("test address", "test city", "test state");
	    Student s1 = new Student(175, "arun", a );
		FileOutputStream fout=new FileOutputStream("E:/aggregation.non.ser");  
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.close();
        fout.close();
        System.out.printf("Serialized data is saved in E:/aggregation.non.ser");
      
        // De-Serialization
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/aggregation.non.ser"));  
        Student s=(Student)in.readObject();  
		System.out.println(s.toString());  
		in.close();  
	}

}
