package com.aes;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AES {
    private SecretKey secretKey;
    private SecureRandom secureRandom;
    private Cipher encryptCipher;
    private Cipher decryptCipher;
    private IvParameterSpec ivParams;

    public AES()
    {
        try {
            secureRandom = new SecureRandom();
            secretKey = KeyGenerator.getInstance("AES").generateKey();
            encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] initializationVector = new byte[encryptCipher.getBlockSize()];
            secureRandom.nextBytes(initializationVector);
            ivParams = new IvParameterSpec(initializationVector);
            encryptCipher.init(Cipher.ENCRYPT_MODE,secretKey, ivParams);
            decryptCipher.init(Cipher.DECRYPT_MODE,secretKey,ivParams);
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
    public String encrypt(String plainText)
    {
        byte[] bytes = plainText.getBytes();
        byte[] cipherText = null;

        try {
            cipherText = encryptCipher.doFinal(bytes);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(cipherText);
    }
    public String decrypt(String cipherText)
    {
        byte[] plainText = null;
        try {
            plainText = decryptCipher.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
            return new String(plainText,"UTF8");
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
