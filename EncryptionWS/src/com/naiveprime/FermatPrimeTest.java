package com.naiveprime;

import java.math.BigInteger;
import java.util.Random;

public class FermatPrimeTest {
    private Random random;

    public FermatPrimeTest() {
        this.random = new Random();
    }

    public boolean isPrime(BigInteger n, int k)
    {
        if(n.intValue()<=1)
            return false;
        if(n.intValue() ==2)
            return true;
        for (int i = 0; i < k; ++i) {
            BigInteger a = BigInteger.valueOf(Integer.valueOf(random.nextInt(n.intValue()-2)+2));
            if(!a.modPow(n.subtract(BigInteger.ONE),n).equals(BigInteger.ONE))
            {
                return false;
            }
            
        }
        return true;

    }
}
