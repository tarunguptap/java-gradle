package com.example.core.apacheutils.collectionutil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.example.common.pojo.ModelSub;

public class CollectionUtilsFilter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelSub s=new ModelSub();
		ModelSub s1=new ModelSub();
		ModelSub s2=new ModelSub();
		ModelSub s3=new ModelSub();
		s.setUid("A");
		s.setUname("tarun");
		s1.setUid("B");
		s1.setUname("tarun");
		s2.setUid("C");
		s2.setUname("arun");
		s3.setUid("D");
		s3.setUname("varun");
		
		System.out.println("=========CollectioUtils.filter===============");
		List newList = new ArrayList();
		newList.add(s);
		newList.add(s1);
		newList.add(s2);
		newList.add(s3);
		System.out.println("before "+newList);
		CollectionUtils.filter(newList, new Predicate() {

			public boolean evaluate(Object object) {
				ModelSub s = (ModelSub) object;
				return( ( s.getUid().equals( "A" ) ) ||
			            ( s.getUid().equals( "B" ) && 
			              s.getUname() == "tarun" ) );
			}

		});
		System.out.println("after "+newList);
	}

}
