package com.example.core.logical.search;

import java.util.Arrays;

/**
 * Binary search is a fast search algorithm with run-time complexity of O(log n)
 * works on the principle of divide and conquer
 * the data collection should be in the sorted form
 * 
 * @author tgupta
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] intArray = { 2, 8, 9, 40, 54, 29, 37, 55, 76 };
        Arrays.sort(intArray);
        int searchIndex = binarySearch(intArray, 29);
        System.out.println("Match fond at Index " + searchIndex);
    }

    /**
     * This method perform the binary search and return the index of found match
     * 
     * @param intArray
     * @param elementToSearch
     * @return int
     */
    private static int binarySearch(Integer[] intArray, int elementToSearch) {
        int first, last, middle, length, searchIndex = 0;
        length = intArray.length;
        first = 0;
        last = length - 1;
        middle = (first + last) / 2;
        while (first <= last) {
            if (intArray[middle] == elementToSearch) {
                searchIndex = middle + 1;
                break;
            } else if (intArray[middle] < elementToSearch) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        return searchIndex;
    }
}
