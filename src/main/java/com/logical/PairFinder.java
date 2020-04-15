package com.logical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

//[1,2,1,2,2,3,4,3,5] = 3 pairs
//The call to contains() will be O(1) for a HashSet versus O(n) for a List
public class PairFinder {
    public static void main(String[] args) {
        int[] array = new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
        AtomicInteger pairs = new AtomicInteger();
        Set<Integer> pairSet = new HashSet<>(array.length);

        Arrays.stream(array).forEach(i -> {
            if (!pairSet.contains(i)) {
                pairSet.add(i);
            } else {
                pairs.incrementAndGet();
                pairSet.remove(i);
            }
        });
        System.out.println(pairs.get());
    }
}
