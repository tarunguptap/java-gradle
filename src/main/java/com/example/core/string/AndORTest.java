package com.example.core.string;

import org.apache.commons.lang.StringUtils;

public class AndORTest {

    public static void main(String[] args) {

        boolean flag1 = true;
        boolean flag2 = false;

        if (flag2 || flag1) {
            System.out.println("OR");
        }

        if (flag1 && flag2) {
            System.out.println("AND");
        } else {
            System.out.println("AND Failed");
        }

        String spaceStr = "  ";
        String spaceStr1 = "  aaa   ";
        System.out.println("String after trim is : " + spaceStr.trim());// Output is blank

        System.out.println("StringUtils.isNotBlank(spaceStr) : " + StringUtils.isNotBlank(spaceStr)); // false
        System.out.println("StringUtils.trimToNull(spaceStr) : " + StringUtils.trimToNull(spaceStr)); // null
        System.out.println("StringUtils.trimToEmpty(spaceStr) : " + StringUtils.trimToEmpty(spaceStr));// Output is
                                                                                                       // blank
        System.out.println("StringUtils.trimToNull(spaceStr1) : " + StringUtils.trimToNull(spaceStr1)); // null

        String str = "0.5";
        System.out.println(Integer.parseInt(str));
        System.out.println(Integer.parseInt(str) * 60000);

    }

}
