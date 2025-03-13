package com.discretealgo;

import java.math.BigInteger;

public class DiscreteLogarithm {

    public BigInteger discreteLogarithm(BigInteger a, BigInteger b, BigInteger m)
    {
        BigInteger c = new BigInteger("1");
        while(b.modPow(c,m).compareTo(a)!=0)
        {
            c = c.add(BigInteger.ONE);
        }
        return c;
    }
    public BigInteger modularExponentiation(BigInteger b, BigInteger c, BigInteger m)
    {
        return b.modPow(c,m);
    }
}
