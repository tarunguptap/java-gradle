package com.example.core.apacheutils.collectionutil;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class CollectionUtilsFind {
	public static void main(String[] args) {
		Set<String> strSet = new HashSet<String>();
		strSet.add("tarun");
		strSet.add("arun");
		
		@SuppressWarnings("unchecked")
        String strSet1 = (String)CollectionUtils.find(strSet, new Predicate() {
			public boolean evaluate(Object res) {
				String cr = (String) res;
				return (cr.equals("tarun"));
			}
		});
		
		System.out.println(strSet1);
	}
}
