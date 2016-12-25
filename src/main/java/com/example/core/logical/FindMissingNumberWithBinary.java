package com.example.core.logical;

public class FindMissingNumberWithBinary {
    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12 };

        int k = missing(a, 0, a.length);
        System.out.println(k);
    }

    public static int missing(int[] a, int f, int l) {

        int mid = (l + f) / 2;

        // if first index reached last then no element found
        if (a.length - 1 == f) {
            System.out.println("missing not find ");
            return 0;
        }

        // if mid with first found
        if (mid == f) {
            System.out.println(a[mid] + 1);
            return a[mid] + 1;
        }

        if ((mid + 1) == a[mid])
            return missing(a, mid, l);
        else
            return missing(a, f, mid);

    }
}
