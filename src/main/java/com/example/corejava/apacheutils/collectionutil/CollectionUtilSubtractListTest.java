package com.example.corejava.apacheutils.collectionutil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.example.common.pojo.ModelSub;


public class CollectionUtilSubtractListTest 
{
	public static void main(String[] args) {
		
	List lst1 =  new ArrayList();
	lst1.add("1");
	lst1.add("2");
	lst1.add("3");
	lst1.add("4");
	lst1.add("5");
	lst1.add("6");
	lst1.add("7");
	
	List lst2 =  new ArrayList();
	lst2.add("3");
	lst2.add("4");
	lst2.add("5");
	
	System.out.println(CollectionUtils.subtract(lst1,lst2));
	
	
	
	ModelSub mdsb1 = new ModelSub();
	ModelSub mdsb2 = new ModelSub();
	ModelSub mdsb3 = new ModelSub();
	
	mdsb1.setUid("123");
	mdsb1.setUname("tarun");
	mdsb2.setUid("223");
	mdsb2.setUname("arun");
	mdsb3.setUid("223");
	mdsb3.setUname("varun");
	
	List<ModelSub> oldList = new ArrayList<ModelSub>();
	oldList.add(mdsb1);
	oldList.add(mdsb2);
	List<ModelSub> newList = new ArrayList<ModelSub>();
	newList.add(mdsb2);
	newList.add(mdsb3);
	List<ModelSub> result = (List<ModelSub>)CollectionUtils.subtract(newList, oldList);
	System.out.println("oldList is "+oldList);
	System.out.println("newList is "+newList);
	System.out.println("resultList is "+result);
	}
}