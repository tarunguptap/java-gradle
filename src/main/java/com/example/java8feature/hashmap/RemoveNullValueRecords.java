package com.example.java8feature.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.cglib.core.CollectionUtils;

public class RemoveNullValueRecords {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "value");
        map.put("test1", "");
        map.put("test2", "   ");
        map.put("test3", null);

        System.out.println(map);

        CollectionUtils.filter(map.values(), x -> StringUtils.isNotBlank((String) x));

        System.out.println(map);

        Map<String, String> map1 = new HashMap<>();
        map1.put("test", "value");
        map1.put("test1", "");
        map1.put("test2", "   ");
        map1.put("test3", null);

        map1.values().removeIf(StringUtils::isBlank);
        System.out.println(map1);

        Map<String, String> map2 = null;

        Optional.ofNullable(map2).orElseGet(Collections::emptyMap).values().removeIf(StringUtils::isBlank);
        System.out.println("map2  :::  " + map2);

    }
}
