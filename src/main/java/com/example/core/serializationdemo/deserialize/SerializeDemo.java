package com.example.core.serializationdemo.deserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo
{
   public static void main(String [] args)
   {
      Employee e = new Employee();
      e.name = "Reyan Ali";
      e.address = "Phokka Kuan, Ambehta Peer";
      e.SSN = 11122333;
      e.number = 101;
      
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("E:/employee.deser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in E:/employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
      
      // Exception will occured : java.io.NotSerializableException: com.example.corejava.serializationdemo.deserialize.Employee
   }
}