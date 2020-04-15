package com.logical.sorting.DivideAndConquer;

/**
 * QuickSort is a Divide and Conquer algorithm
 * It picks last element x as pivot, 
 * start comparing each element from lower index with itself, if any element lesser than its own is found then it starts swapping 
 * that number with starting from number at lower index i in increment manner. Finally when all comparisons are done then it swap itself with the next available index of i.
 *
 */

public class QuickSort {

    public static void main(String args[]) {
        int arr[] = { 6, 4, 7, 3, 9, 8, 1, 5 };
        int n = arr.length;

        sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }

    // This method returns the pivot position
    static int partition(int arr[], int lowerIndex, int higherIndex) {
        int pivot = arr[higherIndex];
        int i = lowerIndex - 1; // index of smaller element
        for (int j = lowerIndex; j < higherIndex; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[higherIndex];
        arr[higherIndex] = temp;

        return i + 1;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            // if (low != pivotIndex - 1) {
            sort(arr, low, pivotIndex - 1);
            // }
            // if (high != pivotIndex + 1) {
            sort(arr, pivotIndex + 1, high);
            // }

        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

/**
 * { 6, 4, 7, 3, 9, 8, 1, 5 }
 * 5 is pivot, starts comparing itself with values right from the lower index , compares with 6 since its big leave it, 
 * compare with 4 since less then swap with first lower index value so 6 and 4 are swapped, now next available index for swapping is lower+1
 * 
 * [4, 6, 7, 3, 9, 8, 1, 5]
 * 
 * now 5>3 so 3 and value at index lower+1 i.e. 6 are swapped, now next available index for swapping is lower+2
 * 
 * [4, 3, 7, 6, 9, 8, 1, 5]
 * 
 * now 5>1 so 1 and 7 are swapped   
 * 
 * [4, 3, 1, 6, 9, 8, 7, 5]
 * 
 * Now pivot and 6 are swapped
 * 
 * [4, 3, 1, 5, 9, 8, 7, 6]
 * 
 * partition(pivotIndex) = 3
 * 
 * call the recursively sort method keeping pivot intact as its at right place.
 * low 0, high = 2
 * low = 4 , high = 7
 * 
 * 
 * low 0, high = 2
 * 4>1 & 3>1 so 1 finally 1 and 4 will be swapped
 * [1, 3, 4, 5, 9, 8, 7, 6]
 * 
 * 1 will be partition
 * 
 * low 0, high = 0   -- no more sorting
 * low = 2 , high = 2 -- no more sorting
 * 
 * low = 3+1=4 , high = 7
 * pivot 6
 * 
 * 9>6, 8>6, 7>6 so swap 
 * [1, 3, 4, 5, 6, 9, 8, 7]
 * 
 * partition = 4
 * [1, 3, 4, 5, 6,7, 9, 8]
 * 
 * partition = 6
 * [1, 3, 4, 5, 6,7, 8, 9]
*/
