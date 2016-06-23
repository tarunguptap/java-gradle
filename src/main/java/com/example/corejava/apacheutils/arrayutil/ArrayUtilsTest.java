package com.example.corejava.apacheutils.arrayutil;

import org.apache.commons.lang.ArrayUtils;

public class ArrayUtilsTest {
	public static void main(String[] args) {
		String str[] = null;
		String str1[] = new String[1];
		if (!ArrayUtils.isEmpty(str1) && str1.length == 1) {
			System.out.println("not empty" + str1[0]);
		} else {
			System.out.println("empty");
		}
		
	}
}
