package com.diffiehellman;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {
    private Random random;

    public DiffieHellman() {
        this.random = new Random();
    }

    public void generatePrivateKeys(BigInteger n, BigInteger g)
    {
        int rand1 = random.nextInt( n.intValue()-2)+1;
        BigInteger x = new BigInteger(Integer.toString(rand1));

        int rand2 = random.nextInt( n.intValue()-2)+1;
        BigInteger y = new BigInteger(Integer.toString(rand2));

        BigInteger k1 = g.modPow(x,n);
        BigInteger k2 = g.modPow(y,n);

        BigInteger key1 = k2.modPow(x,n);
        BigInteger key2 = k1.modPow(y,n);

        System.out.println("Alice private key:"+key1.intValue());
        System.out.println("Bob private key:"+key2.intValue());
    }
}
