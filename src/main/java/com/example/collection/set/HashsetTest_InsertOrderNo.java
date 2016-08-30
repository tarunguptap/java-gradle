package com.example.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashsetTest_InsertOrderNo {
	public static void main(String[] args) {
		  Set<Integer> al=new HashSet<Integer>();  
		  al.add(3);  
		  al.add(19);  
		  al.add(1);  
		  al.add(6);  
		  
		  Iterator<Integer> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
	}

}
