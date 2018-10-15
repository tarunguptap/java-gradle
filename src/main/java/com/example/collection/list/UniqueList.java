package com.example.collection.list;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.collections.list.SetUniqueList;
import org.apache.commons.lang.StringUtils;

public class UniqueList {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("tarun, arun, ajay, tarun, arun"));
    }

    private static final String removeDuplicates(final String str) {
        final String[] strArray = StringUtils.split(str);
        return StringUtils.join(SetUniqueList.decorate(new ArrayList<String>(Arrays.<String> asList(strArray)))
                .iterator(), " ");
    }

}
