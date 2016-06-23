package com.example.corejava.apacheutils.collectionutil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;


import com.example.common.pojo.ModelSub;

public class CollectionUtilsWithTransformModel 
{
	public static void main(String[] args) 
	{
		ModelSub s=new ModelSub();
		ModelSub s1=new ModelSub();
		ModelSub s2=new ModelSub();
		ModelSub s3=new ModelSub();
		s.setUid("A");
		s.setUname("TARUN");
		s1.setUid("B");
		s1.setUname("VARUN");
		s2.setUid("C");
		s2.setUname("ARUN");
		s3.setUid("D");
		s3.setUname("KARUN");
		
		Set<ModelSub> newSet = new HashSet<ModelSub>();
		newSet.add(s);
		newSet.add(s1);
		newSet.add(s2);
		newSet.add(s3);
		System.out.println("newSet before transform is "+newSet);
		CollectionUtils.transform(newSet, new Transformer() {
			
			@Override
			public Object transform(Object obj) {
				return ((ModelSub)obj).getUname().toLowerCase();
			}
		});
		System.out.println("newSet after transform is "+newSet);
		
		
		
		List<String> OrderList = new ArrayList<String>(CollectionUtils.collect(newSet
				, new Transformer() {

			@Override
			public Object transform(Object o) {
				return ((ModelSub) o).getUid();
			}
		}));
		System.out.println(OrderList);
	}
}
