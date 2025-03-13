package com.rsa;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        String message = "This is a cryptography related message!";
        RSA rsa = new RSA();
        rsa.generateKeys(1024);
        BigInteger cipherText = rsa.encryptMessage(message);
        System.out.println(cipherText);
        System.out.println(rsa.decryptMessage(cipherText));

    }
}
