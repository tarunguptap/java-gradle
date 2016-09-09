package com.example.collection.collectionutils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class CollectionUtil_Subtract {
    public static void main(String[] args) {
        List<Long> longList = new ArrayList<Long>();
        longList.add(1L);
        longList.add(2L);
        longList.add(3L);
        longList.add(1L);
        
        List<Long> longList1 = new ArrayList<Long>();
        longList1.add(1L);
        longList1.add(2L);
        longList1.add(3L);
        
        List<Long> duplicateObjectList = ((List<Long>) CollectionUtils.subtract(longList,
                longList1));
        
        System.out.println(duplicateObjectList);
    }
}
