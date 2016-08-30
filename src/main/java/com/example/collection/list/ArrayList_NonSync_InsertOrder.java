package com.example.collection.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayList_NonSync_InsertOrder {

	public static void main(String[] args) {
		
		List<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(10);
		arrayList.add(3);
		arrayList.add(11);
		System.out.println(arrayList);
		
		List<Integer> arrayList1=new ArrayList<Integer>();
		arrayList1.add(53);
		arrayList1.add(104);
		arrayList1.add(35);
		arrayList1.add(116);
		arrayList1.add(0,98);
		
		
		List<Integer> arrayListRemove=new ArrayList<Integer>();
		arrayListRemove.add(5);
		arrayListRemove.add(10);
		arrayListRemove.add(3);
		arrayListRemove.add(11);
		// TODO Auto-generated method stub
		arrayList.addAll(arrayList1);
		//arrayList.removeAll(arrayListRemove);
		
		iterator(arrayList);
		arrayList.retainAll(arrayList1); // remove rest elements apart from arrayList1
		System.out.println("======================================================");
		forLoop(arrayList);
		System.out.println("======================================================"+arrayList.size());
		listIterator(arrayList);
		
		

	}
	public static void iterator(List<Integer> arrayList){
		Iterator<Integer> itr=arrayList.iterator();
		while(itr.hasNext()){
			System.out.println("iterator : "+itr.next());
		}
		
	}
	
	public static void forLoop(List<Integer> arrayList){
		
		for(Integer it:arrayList){
			System.out.println("for loop : "+it);
			
		}
		
	}
	
	public static void listIterator(List<Integer> arrayList){
		
		ListIterator<Integer> itr=arrayList.listIterator();
		while(itr.hasNext()){
			System.out.println(""+itr.next());
		}
		while(itr.hasPrevious()){
			System.out.println("list iterator : "+itr.previous());
		}
		
	}
}




/*Java ArrayList class uses a dynamic array for storing the elements.It extends AbstractList
class and implements List interface.
Java ArrayList class can contain duplicate elements.
Java ArrayList class maintains insertion order.
Java ArrayList class is non synchronized.
Java ArrayList allows random access because array works at the index basis.
In Java ArrayList class, manipulation is slow because a lot of shifting needs to be occurred
if any element is removed from the array list.*/
