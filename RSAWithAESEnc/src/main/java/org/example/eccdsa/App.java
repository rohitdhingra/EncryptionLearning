package org.example.eccdsa;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.util.Base64;

public class App {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException, InvalidKeyException {
        Security.addProvider(new BouncyCastleProvider());

        KeyPair keys1 = CryptograpyHelper.generateKeys();
        KeyPair keys2 = CryptograpyHelper.generateKeys();
        String m = "This is a message";

        byte[] signature = CryptograpyHelper.sign(keys1.getPrivate(), m);
        System.out.println(CryptograpyHelper.verify(keys2.getPublic(),m,signature));
//        System.out.println(Base64.getEncoder().encodeToString(CryptograpyHelper.sign(keys.getPrivate(),"This is a message")));

    }
}
