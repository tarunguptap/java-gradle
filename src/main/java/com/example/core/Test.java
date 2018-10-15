package com.example.core;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date holdEnddate = new Date();
        System.out.println(new Date().compareTo(holdEnddate) <= 0);

    }
}
