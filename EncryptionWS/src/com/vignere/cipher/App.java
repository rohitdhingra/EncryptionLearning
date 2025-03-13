package com.vignere.cipher;

public class 	App {

	public static void main(String[] args) {
		
		VigenereCipher cipher = new VigenereCipher();
		
		String cipherText = cipher.encrypt("Cryptography is quite important", "table");
		
		System.out.println(cipherText);
		System.out.println(cipher.decrypt(cipherText, "table"));
		
	}
}
