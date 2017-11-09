package com.example.core.MultiValueMapUtil;

import java.util.HashMap;

import org.apache.commons.collections.map.MultiValueMap;

public class MultiValueMapUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiValueMap multiValueMap=MultiValueMap .decorate(new HashMap<String,Integer>());
		multiValueMap.put("a",1);
		multiValueMap.put("a",2);
		
		System.out.println(multiValueMap.get("a"));

	}

}
