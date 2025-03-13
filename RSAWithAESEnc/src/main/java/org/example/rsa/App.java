package org.example.rsa;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.example.aes.AES;

import javax.crypto.*;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.MGF1ParameterSpec;
import java.util.HexFormat;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Security.addProvider(new BouncyCastleProvider());

        String message= "This is just a simple message";
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = generator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println(privateKey);
        System.out.println(publicKey);

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey sessionKey = keyGenerator.generateKey();
        System.out.println(HexFormat.of().formatHex(sessionKey.getEncoded()));

        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);

        AES aesEncryption = new AES(sessionKey,iv);
        String cipherText = aesEncryption.encrypt(message);

        System.out.println("Cipher Text:"+cipherText);

        Cipher encryptionCipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA256AndMGF1Padding");
        OAEPParameterSpec spec = new OAEPParameterSpec("SHA-256","MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        encryptionCipher.init(Cipher.ENCRYPT_MODE,publicKey,spec);

        byte[] encryptedSessionKey = encryptionCipher.doFinal(sessionKey.getEncoded());
        System.out.println(HexFormat.of().formatHex(encryptedSessionKey));

        Cipher decryptionCipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA256AndMGF1Padding");
        OAEPParameterSpec spec2 = new OAEPParameterSpec("SHA-256","MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        decryptionCipher.init(Cipher.DECRYPT_MODE,privateKey,spec2);

        byte[] decryptedKey = decryptionCipher.doFinal(encryptedSessionKey);
        System.out.println(HexFormat.of().formatHex(decryptedKey));

        SecretKeySpec decryptedSessionKey = new SecretKeySpec(decryptedKey, 0, decryptedKey.length, "AES");
        AES decryptAES = new AES(decryptedSessionKey,iv);

        System.out.println("Decrypted Message: "+decryptAES.decrypt(cipherText));
    }
}
