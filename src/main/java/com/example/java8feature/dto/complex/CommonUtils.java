package com.example.java8feature.dto.complex;

import java.util.Collection;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;

public class CommonUtils {

    public static <T> Stream<T> collectionToStream(Collection<T> collection) {
        return CollectionUtils.isNotEmpty(collection) ? collection.stream() : Stream.empty();
    }
}
