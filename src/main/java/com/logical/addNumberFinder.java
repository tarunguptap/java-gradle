package com.logical;

import java.util.ArrayList;
import java.util.List;

public class addNumberFinder {
    public static void main(String[] args) {

        oddNumbers(5, 100);
    }

    private static List<Integer> oddNumbers(int l, int r) {
        if (l % 2 == 0) {
            l = l + 1;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = l; i <= r; i += 2) {
            list.add(i);
        }
        System.out.println(list);
        return list;
    }
}
