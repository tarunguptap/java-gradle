package com.example.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

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
        System.out.println("multiMap @@@ " + multiMap);

        // apache commons implemenatation
        MultiValueMap<Long, String> multiValueMap = new LinkedMultiValueMap<Long, String>();
        multiValueMap.add(1L, "tarun");
        multiValueMap.add(1L, "arun");
        multiValueMap.add(1L, "varun");
        multiValueMap.add(1L, "varun");
        multiValueMap.add(2L, "ajay");
        System.out.println("multiValueMap @@@ " + multiValueMap);

        Map<Long, String> map = org.apache.commons.collections.map.MultiValueMap
                .decorate(new LinkedHashMap<Long, String>());
        map.put(1L, "tarun");
        map.put(1L, "arun");
        map.put(1L, "varun");
        map.put(1L, "varun");
        System.out.println("map @@@ " + multiValueMap);

    }
}
