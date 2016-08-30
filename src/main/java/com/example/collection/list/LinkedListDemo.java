package com.example.collection.list;

import java.util.LinkedList;

public class LinkedListDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add("F");
		ll.add("B");
		ll.add("D");
		ll.add("E");
		ll.add("C");
		System.out.println("original element ==="+ll);
		ll.addLast("Z");
		ll.addFirst("A");
		System.out.println("original element after ==="+ll);
		ll.remove("F");
		System.out.println("after removing F  "+ll);
		ll.remove(2);
		System.out.println("after removing 2nd element "+ll);
		ll.removeFirst();
		System.out.println("after removing First "+ll);
		ll.removeLast();
		System.out.println("after removing last"+ll);
		System.out.println("2nd element value "+ ll.get(2));
		
		ll.set(2, "val changed");
		System.out.println("after 2nd eleent changed "+ll);
	}
}
