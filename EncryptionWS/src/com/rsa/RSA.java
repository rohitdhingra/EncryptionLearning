package com.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;

public class RSA {
    private BigInteger publicKey;
    private BigInteger privateKey;
    private BigInteger n;
    private SecureRandom secureRandom;

    public RSA() {
        this.secureRandom = new SecureRandom();
    }

    public void generateKeys(int keyDigits)
    {
        BigInteger p = BigInteger.probablePrime(keyDigits, secureRandom);
        BigInteger q = BigInteger.probablePrime(keyDigits, secureRandom);
        this.n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = generatePublicFactor(phi);
        BigInteger d = e.modInverse(phi);
        this.privateKey = d;
        this.publicKey = e;

    }

    private BigInteger generatePublicFactor(BigInteger phi) {
        BigInteger e = new BigInteger(phi.bitLength(), secureRandom);
        while(!e.gcd(phi).equals(BigInteger.ONE))
        {
            e = new BigInteger(phi.bitLength(),secureRandom);
        }
        return e;

    }

    public BigInteger encryptMessage(String message)
    {
        return encrypt(publicKey,n,message);
    }

    private BigInteger encrypt(BigInteger e, BigInteger n, String message) {
//        System.out.println(e);
//        System.out.println(n);
        byte[] messageBytes = message.getBytes();
        BigInteger messageInt = new BigInteger(messageBytes);
        return messageInt.modPow(e,n);

    }

    public String decryptMessage(BigInteger message)
    {
        return decrypt(privateKey,n,message);
    }

    private String decrypt(BigInteger d, BigInteger n, BigInteger cipherText) {
        BigInteger messageInt = cipherText.modPow(d, n);
        return new String(messageInt.toByteArray());
    }
    
}
