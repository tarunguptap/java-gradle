package com.example.core.apacheutils.booleanutil;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;

public class BooleanUtilNullTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "";
        System.out.println(BooleanUtils.toBoolean(str));
        System.out.println(Boolean.valueOf(str));

        Object str1 = "abc";
        System.out.println("string to boolean test :::: " + BooleanUtils.toBoolean((String) str1));
        System.out
                .println("string to boolean test1 :::: " + BooleanUtils.isTrue(BooleanUtils.toBoolean((String) str1)));
        System.out.println("string to boolean test :::: " + BooleanUtils.isTrue((Boolean) str1)); // Exception

        Object str2 = null;
        System.out.println("##### " + BooleanUtils.isTrue((Boolean) str2));

        Object str3 = "";
        // System.out.println("##### " + BooleanUtils.isTrue((Boolean) str3)); // Exception

        Map<String, Object> initialInformation = new HashMap<>();
        System.out.println(BooleanUtils.toBoolean((Boolean) initialInformation.get("flag")));
        System.out.println(initialInformation.get("flag"));

        if ((Boolean) initialInformation.get("flag")) {
            System.out.println("true hai");
        } else {
            System.out.println("false hai");
        }

    }

}
