package org.example.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public String digest(String message) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] messageDigestBytes = messageDigest.digest(message.getBytes());
        String hexaHash = new BigInteger(1, messageDigestBytes).toString(16);
        while (hexaHash.length()<32)
        {
            hexaHash = "0"+hexaHash;
        }
        return  hexaHash;

    }
}
