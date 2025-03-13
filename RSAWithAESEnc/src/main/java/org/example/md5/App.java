package org.example.md5;

import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MD5 md5 = new MD5();
//        String message = "Hashin method is crucial in cryptography!";
//        System.out.println(md5.digest(message));

        SHA256 sha256 = new SHA256();
        String message = "Hashing method is crucial in cryptography!";
        System.out.println(sha256.digest(message));
    }
}
