package com.example.core.serialization.NonSerializationExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class NonSerializationDemo
{
   public static void main(String [] args) throws Exception
   {
	   // Serialization
	    Employee e1 = new Employee(175L, "arun");
		FileOutputStream fout=new FileOutputStream("E:/employee.non.ser");  
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(e1);
        out.close();
        fout.close();
        System.out.printf("Serialized data is saved in E:/employee.non.ser");
      
        // De-Serialization
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:/employee.non.ser"));  
		Employee s=(Employee)in.readObject();  
		System.out.println(s.id+" "+s.name);  
		in.close();  
        
      // Exception will occured : java.io.NotSerializableException: com.example.corejava.serializationdemo.deserialize.Employee
   }
}
