package com.example.corejava.bolean.booleanutil;

import org.apache.commons.lang.BooleanUtils;

public class BooleanUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "";
		System.out.println(BooleanUtils.toBoolean(str));
		System.out.println(Boolean.valueOf(str));
	}

}
