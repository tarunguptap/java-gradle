package com.example.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIterator_Fwd_Back_Itr {
	public static void main(String[] args) {
		List<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(10);
		arrayList.add(3);
		arrayList.add(11);
		ListIterator<Integer> itr=arrayList.listIterator();
		while(itr.hasNext()){
			System.out.println(""+itr.next());
		}
		while(itr.hasPrevious()){
			System.out.println("list iterator : "+itr.previous());
		}
	}

}
