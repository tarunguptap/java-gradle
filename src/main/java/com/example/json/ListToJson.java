package com.example.json;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;

public class ListToJson {
	public static void main(String[] args) {
		List<Long> longlist = Arrays.asList(1111L, 3333L, 4444L);
		
		System.out.println(new JSONArray().put(longlist).toString());
	}
	
	/*
	 * [
	 * 	[
	 * 		1111,
	 * 		3333,
	 * 		4444
	 * 	]
	 * ]
	 */
}
