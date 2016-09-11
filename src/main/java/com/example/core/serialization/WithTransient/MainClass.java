package com.example.core.serialization.WithTransient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Java Serialization with static data member
 * If there is any static data member in a class, it will not be serialized because static is the part of class not object. 
 */
public class MainClass {

	public static void main(String[] args) throws Exception{
		// Serialization
	    Employee s1 = new Employee(170L, "arun", 123);
		FileOutputStream fout=new FileOutputStream("E:/transient.non.deser");  
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.close();
        fout.close();
        System.out.println("Serialized data is saved in E:/transient.non.deser");
      
        // De-Serialization
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/transient.non.deser"));  
        Employee s=(Employee)in.readObject();  
		System.out.println("name "+s.name +" id "+ s.id +" address "+ s.SSN);  
		in.close();  
	}

}
