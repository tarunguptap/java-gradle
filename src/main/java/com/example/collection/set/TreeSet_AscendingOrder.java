package com.example.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TreeSet_AscendingOrder {
	public static void main(String[] args) {
		  Set<String> al=new HashSet<String>();  
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
