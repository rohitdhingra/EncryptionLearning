package org.example.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    public String digest(String message) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("SHA-256");
        byte[] messageDigestBytes = m.digest(message.getBytes());
        String hexaHash = new BigInteger(1, messageDigestBytes).toString(16);
        while (hexaHash.length() < 64)
            hexaHash = "0"+hexaHash;

        return hexaHash;

    }
}
