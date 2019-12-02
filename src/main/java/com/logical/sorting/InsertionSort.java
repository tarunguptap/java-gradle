package com.logical.sorting;

// Pick item from index 1 and start comparing it with left element and swap it if its smaller than left one and keep on swapping with other elements till final position
public class InsertionSort {

    public static void main(String args[]) {
        int arr[] = { 4, 3, 2, 10, 12, 1, 5, 6 };
        sort(arr);
        printArray(arr);
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
