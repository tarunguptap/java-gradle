package com.example.collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
	public static void main(String[] args) {
		   
		  HashSet<String> al=new HashSet<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ravi");  
		  al.add("Ajay");  
		  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
	}

}


/*HashSet doesn’t maintain any order, the elements would be returned in any random order.
HashSet doesn’t allow duplicates. If you try to add a duplicate element in HashSet, the old value would be overwritten.
HashSet allows null values however if you insert more than one nulls it would still return only one null value.
HashSet is non-synchronized.
The iterator returned by this class is fail-fast which means iterator would throw ConcurrentModificationException
if HashSet has been modified after creation of iterator, by any means except iterator’s own remove method.*/

