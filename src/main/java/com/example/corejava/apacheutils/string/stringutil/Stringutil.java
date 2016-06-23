package com.example.corejava.apacheutils.string.stringutil;

import org.apache.commons.lang.StringUtils;

public class Stringutil {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
			System.out.println(StringUtils.uncapitalize("TARUN"));
			System.out.println(StringUtils.substringAfterLast(Stringutil.class.getName(), "."));
	}
	public static String getDataClassAlias(Class clazz) {
        return StringUtils.uncapitalize(StringUtils.substringAfterLast(clazz
                .getName(), "."));
    }
}
