package com.discretealgo;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        DiscreteLogarithm algo = new DiscreteLogarithm();
        BigInteger b = new BigInteger("5");
        BigInteger c = new BigInteger("948603");
        BigInteger m = new BigInteger("9048610007");

        BigInteger a = algo.modularExponentiation(b, c, m);
        System.out.println(a);

        System.out.println(algo.discreteLogarithm(a,b,m));
    }
}
