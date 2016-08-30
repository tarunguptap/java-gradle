package com.example.collection.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashsetTest_InsertOrderYes {
	public static void main(String[] args) {
		  Set<String> al=new LinkedHashSet<String>();  
		  al.add("first");  
		  al.add("second");  
		  //al.add("Ravi");  
		  al.add("third");  
		  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
	}

}
