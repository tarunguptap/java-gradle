package com.example.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedList_NonSync_InsertOrder {
	public static void main(String[] args) {
		List<Integer> linkedList=new LinkedList<Integer>();
		linkedList.add(5);
		linkedList.add(10);
		linkedList.add(3);
		linkedList.add(11);
		System.out.println(linkedList);
	}

}
