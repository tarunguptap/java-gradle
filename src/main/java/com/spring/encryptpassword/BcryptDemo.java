package com.spring.encryptpassword;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BcryptDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String originalPassword = "Password1";
        String generatedSecuredPasswordHash12 = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash12);

        boolean matched12 = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash12);
        System.out.println("generatedSecuredPasswordHash12 : " + matched12);

        String generatedSecuredPasswordHash10 = BCrypt.hashpw(originalPassword, BCrypt.gensalt(10));
        System.out.println(generatedSecuredPasswordHash10);

        boolean matched10 = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash10);
        System.out.println("generatedSecuredPasswordHash10 : " + matched10);
    }

}
