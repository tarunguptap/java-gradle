package com.example.encryption;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class ShaEncryption {
    public static void main(String[] args) {
        ShaPasswordEncoder sha = new ShaPasswordEncoder();
        String hash = sha.encodePassword("Password1", "900000000000005818"); // 2fb9c5b372d40221e75172807fc3f0b7dde39c16
        System.out.println(hash);
        String hash1 = sha.encodePassword("Password1", "900000000000005819"); // ae6ed5281017f8baa3848b13d9d7ae9bfcbd1aa9
        System.out.println(hash1);
        String hash2 = sha.encodePassword("Password1", "900000000000005820"); // 7a8348fef5c810a8480aac6b0e44b4d6bb57f94b
        System.out.println(hash2);
        String hash3 = sha.encodePassword("Password1", "900000000000005821"); // 02e7b8e1195e0238df2a77587134ea834ae02b9c
        System.out.println(hash3);
        String hash4 = sha.encodePassword("Password1", "900000000000005822"); // 19df8105891d9d7a337c528209d041fcaa2308ee
        System.out.println(hash4);
    }
}
