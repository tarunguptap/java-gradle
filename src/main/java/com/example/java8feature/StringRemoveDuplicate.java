package com.example.java8feature;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.collections.list.SetUniqueList;
import org.apache.commons.lang.StringUtils;

//not working
public class StringRemoveDuplicate {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,5,6,6,7,7";
        final String[] strArray = StringUtils.split(str);
        String str1 = StringUtils.join(SetUniqueList.decorate(new ArrayList<String>(Arrays.<String> asList(strArray)))
                .iterator(), " ");
        System.out.println(str1);
    }
}
