package com.example.core.logical.sort;

public class QuickSort {
    private int[] numberArray;
    private int number;

    public static void main(String a[]) {

        QuickSort sorter = new QuickSort();
        int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
        sorter.sort(input);
        printArrayElements(input);
    }

    private static void printArrayElements(int[] input) {
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public void sort(int[] numberArray) {
        // check for empty or null array
        if (numberArray == null || numberArray.length == 0) {
            return;
        }
        this.numberArray = numberArray;
        number = numberArray.length;
        quickSort(0, number - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        System.out.print(" lowerIndex " + lowerIndex + " higherIndex :" + higherIndex + " Array Elements : ");
        printArrayElements(numberArray);
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = numberArray[lowerIndex + (higherIndex - lowerIndex) / 2];
        System.out.println(" pivot " + pivot);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (numberArray[i] < pivot) {
                i++;
            }
            while (numberArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = numberArray[i];
        numberArray[i] = numberArray[j];
        numberArray[j] = temp;
    }

}
