package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Features {
    public static void main(String[] args) {

        /**
         * Stream
         * stream : Returns a sequential stream considering collection as its source.
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("stream filtered list :: " + filtered);
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("stream empty string count :: " + count);

        /**
         * Stream
         * parallelStream : Returns a parallel Stream considering collection as its source.
         */
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // get count of empty string
        long count1 = strings1.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("parallel stream empty string count :: " + count1);

        /**
         * Stream
         * Subtract two lists
         */
        List<String> strings2 = Arrays.asList("abc", "efd", "bc", "efg", "abcd", "pou", "jkl");
        List<String> strings3 = Arrays.asList("abc", "efd", "bc", "efg");

        List<String> difference = strings2.stream().filter(strings3::contains).collect(Collectors.toList());
        System.out.println("list difference :: " + difference);

        /**
         * forEach / limit / sorted
         * Stream has provided a new method ‘forEach’ to iterate each element of the stream. The following code segment
         * shows how to print 10 random numbers using forEach.
         */
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        /**
         * map / Collectors
         * The ‘map’ method is used to map each element to its corresponding result. The following code segment prints
         * unique squares of numbers using map.
         * 
         * Collectors are used to combine the result of processing on the elements of a stream. Collectors can be used
         * to return a list or a string.
         */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // get list of unique squares
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("squaresList :: " + squaresList);

        /**
         * Collectors
         * 
         */

    }
}
