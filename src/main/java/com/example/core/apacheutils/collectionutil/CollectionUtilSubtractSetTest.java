package com.example.core.apacheutils.collectionutil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.example.common.pojo.ModelSub;

public class CollectionUtilSubtractSetTest {
	public static void main(String[] args) {

		
		Set<String> lst1 =  new HashSet<String>();
		lst1.add("1");
		lst1.add("2");
		lst1.add("3");
		lst1.add("4");
		lst1.add("5");
		lst1.add("6");
		lst1.add("7");
		
		Set<String> lst2 =  new HashSet<String>();
		lst2.add("3");
		lst2.add("4");
		lst2.add("5");
		
		System.out.println(CollectionUtils.subtract(lst1,lst2));
		
		
		ModelSub mdsb1 = new ModelSub();
		ModelSub mdsb2 = new ModelSub();
		ModelSub mdsb3 = new ModelSub();
		
		mdsb1.setUid("123");
		mdsb1.setUname("tarun");
		mdsb2.setUid("224");
		mdsb2.setUname("arun");
		mdsb3.setUid("223");
		mdsb3.setUname("varun");
		
		Set<ModelSub> oldList = new HashSet<ModelSub>();
		oldList.add(mdsb1);
		oldList.add(mdsb2);
		oldList.add(mdsb3);
		Set<ModelSub> newList = new HashSet<ModelSub>();
		newList.add(mdsb2);
		List<ModelSub> result = (List<ModelSub>)CollectionUtils.subtract(oldList,newList);
		System.out.println("oldList is "+oldList);
		System.out.println("newList is "+newList);
		System.out.println("resultList is "+result);
		
	}
}
