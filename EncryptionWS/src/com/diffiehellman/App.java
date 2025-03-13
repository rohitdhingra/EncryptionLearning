package com.diffiehellman;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        BigInteger n = new BigInteger(Integer.toString(37));
        BigInteger g = new BigInteger(Integer.toString(13));

        DiffieHellman algo = new DiffieHellman();
        algo.generatePrivateKeys(n,g);
    }
}
