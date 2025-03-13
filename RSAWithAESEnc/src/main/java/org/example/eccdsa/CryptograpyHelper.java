package org.example.eccdsa;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class CryptograpyHelper {
    public static KeyPair generateKeys() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA","BC");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        ECGenParameterSpec params = new ECGenParameterSpec("prime256v1");
        keyPairGenerator.initialize(params,random);
        return keyPairGenerator.generateKeyPair();
    }
    public static byte[] sign(PrivateKey privateKey,String message) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("ECDSA","BC");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] output = new byte[0];
        output = signature.sign();
        return output;
    }
    public static boolean verify(PublicKey publicKey, String message, byte[] signature) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature algorithm = Signature.getInstance("ECDSA", "BC");
        algorithm.initVerify(publicKey);
        algorithm.update(message.getBytes());
        return algorithm.verify(signature);

    }
}
