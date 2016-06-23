package com.example.corejava.apacheutils.booleanutil;

import org.apache.commons.lang.BooleanUtils;

public class CustomBooleanUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "true";
		System.out.println("arg[1] match== "+BooleanUtils.toBoolean(str1, "true", "false"));
		
		String str2 = "false";
		System.out.println("arg[2] match== "+BooleanUtils.toBoolean(str2, "true", "false"));
		
		String str3 = null;
		System.out.println("no match custom return== "+CustomBooleanUtils.toBoolean(str3, "true", "false"));
		
		Boolean flag = true;
		System.out.println("Boolean to String with match "+BooleanUtils.toString(flag != null ? flag : null, "true", "false"));
		
		Boolean flag1 = null;
		System.out.println("CustomBooleanUtils to String with match "+CustomBooleanUtils.toString(flag1 != null ? flag1 : null, "true", "false"));
		
		Boolean flag2 = null;
		System.out.println("Boolean to String with match "+BooleanUtils.toString(flag2 != null ? flag2 : null, "true", "false"));
		
		String str = "xyz";
		System.out.println("No match "+BooleanUtils.toBoolean(str, "true", "false"));
		
		
		
	}
	
	/**
	 * This method takes the three arguments. 1. String to match, 2. trueString 3.falseString.
	 * It will return true if no string is matched.
	 */
	public static boolean toBoolean(String str, String trueString,
			String falseString) {
		try{
			return BooleanUtils.toBoolean(str, trueString, falseString);
		}catch(RuntimeException runtimeException){
			return true;
		}
	}

	/**
	 * This method takes the three arguments. 1. Boolean to match, 2. trueString 3.falseString.
	 * It will return true if no string is matched.
	 */
	public static String toString(Boolean flag, String trueString,
			String falseString) {
		try{
			return BooleanUtils.toString(flag, trueString, falseString);
		}catch(RuntimeException runtimeException){
			return "true";
		}
	}
	
}
