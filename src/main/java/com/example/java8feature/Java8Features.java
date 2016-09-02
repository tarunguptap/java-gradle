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
         * filter
         */
        Customer customer = getCustomerList().stream() // Convert to steam
                .filter(x -> "arun3".equals(x.getFirstname())) // we want "arun3" only
                .findAny() // If 'findAny' then return found
                .orElse(null); // If not found, return null
        System.out.println("filtered customer name :: " + customer.getFirstname());

        String name = getCustomerList().stream().filter(x -> "arun3".equals(x.getFirstname()))
                .map(Customer::getFirstname)                       // convert stream to String
                .findAny().orElse("");
        System.out.println("name is :: " + name);

        /**
         * Custom predicate in filter
         */
        Customer result = getCustomerList().stream().filter(x -> {
            if ("arun2".equals(x.getFirstname()) && 2L == x.getId()) {
                return true;
            }
            return false;
        }).findAny().orElse(null);
        System.out.println("result :: " + result.getFirstname());

    }

    private static List<Customer> getCustomerList() {
        Customer customer1 = new Customer(1L, "arun1");
        Customer customer2 = new Customer(2L, "arun2");
        Customer customer3 = new Customer(3L, "arun3");
        Customer customer4 = new Customer(4L, "arun4");
        Customer customer5 = new Customer(5L, "arun5");
        Customer customer6 = new Customer(6L, "arun6");
        List<Customer> customerList = Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6);
        return customerList;
    }
}
