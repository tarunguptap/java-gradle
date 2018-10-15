package com.example.collection.map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MultiMap {
    public static void main(String[] args) {

        // Google guava implementation
        Multimap<Long, String> multiMap = ArrayListMultimap.create();
        multiMap.put(1L, "tarun");
        multiMap.put(1L, "arun");
        multiMap.put(1L, "varun");
        multiMap.put(1L, "varun");
        System.out.println(multiMap);

        // apache commons implemenatation
        MultiValueMap<Long, String> multiValueMap = new LinkedMultiValueMap<Long, String>();
        multiValueMap.add(1L, "tarun");
        multiValueMap.add(1L, "arun");
        multiValueMap.add(1L, "varun");
        multiValueMap.add(1L, "varun");
        System.out.println(multiValueMap);

    }
}
