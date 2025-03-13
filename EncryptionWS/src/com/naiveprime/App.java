package com.naiveprime;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        NaivePrimeTest algorithm = new NaivePrimeTest();
//        System.out.println(algorithm.isPrime(2147483647));
        System.out.println(algorithm.isPrime(672804137));

        FermatPrimeTest fermatPrimeTest = new FermatPrimeTest();
        System.out.println(fermatPrimeTest.isPrime(BigInteger.valueOf(101),10));
    }
}
