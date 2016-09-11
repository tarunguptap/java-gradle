package com.example.core.serialization.WithStaticDataMember;

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
	    Employee s1 = new Employee(170L, "arun", "updatedAddress");
		FileOutputStream fout=new FileOutputStream("E:/static.non.deser");  
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.close();
        fout.close();
        System.out.println("Serialized data is saved in E:/static.non.deser");
      
        // De-Serialization
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/static.non.deser"));  
        Employee s=(Employee)in.readObject();  
		System.out.println("name "+s.name +" id "+ s.id +" address "+ s.address);  
		in.close();  
	}

}
