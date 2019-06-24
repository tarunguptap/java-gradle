package com.example.core.MultiValueMapUtil;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.map.MultiValueMap;

public class MultiValueMapUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MultiValueMap multiValueMap = MultiValueMap.decorate(new HashMap<String, Integer>());
        multiValueMap.put("a", 1);
        multiValueMap.put("a", 2);
        multiValueMap.put("b", 3);

        System.out.println(multiValueMap.get("a"));

        List<Integer> ib = (List<Integer>) multiValueMap.get("b");

        List<Integer> ia = (List<Integer>) multiValueMap.get("a");

        System.out.println(ia);

        System.out.println(ib);

        Integer iaa = ia.get(0);

        System.out.println(iaa);

    }

}
