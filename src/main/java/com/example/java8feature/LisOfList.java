package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class LisOfList {

    private static Map<Object, Integer> process(List<List<String>> sampleData, List<String> sources) {
        AtomicInteger ai = new AtomicInteger();
        return sampleData
                .stream()
                .filter(CollectionUtils::isNotEmpty)
                .filter(list -> StringUtils.isNotBlank(list.get(0)))
                .filter(list -> StringUtils.isNotBlank(list.get(1)))
                .map(list -> {
                    list.addAll(Arrays.asList(list.get(3).split(",")).stream().map(str -> str.split(":"))
                            .map(arr -> arr[1]).collect(Collectors.toList()));
                    return list;
                }).filter(list -> sources.contains(list.get(8)))
                .peek(val -> ai.addAndGet(Integer.parseInt(val.get(5))))
                .collect(Collectors.toMap(list -> list.get(8), list -> Integer.parseInt(list.get(5)), Integer::sum));
    }
}
