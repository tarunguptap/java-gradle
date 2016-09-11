package com.example.core.serialization.WithAggregation.SerializedObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java Serialization with Aggregation (HAS-A Relationship) :
 * If a class has a reference of another class, all the references must be Serializable otherwise serialization process 
 * will not be performed. In such case, NotSerializableException is thrown at runtime.
 *
 */
public class MainClass {

	public static void main(String[] args) throws Exception{
		// Serialization
				Address a = new Address("test address", "test city", "test state");
			    Student s1 = new Student(175, "arun", a );
				FileOutputStream fout=new FileOutputStream("E:/aggregation.ser");  
		        ObjectOutputStream out = new ObjectOutputStream(fout);
		        out.writeObject(s1);
		        out.close();
		        fout.close();
		        System.out.println("Serialized data is saved in E:/aggregation.ser");
		      
		        // De-Serialization
		        ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/aggregation.ser"));  
		        Student s=(Student)in.readObject();  
				System.out.println("Serialized data is "+s.toString());  
				in.close();
	}

}
