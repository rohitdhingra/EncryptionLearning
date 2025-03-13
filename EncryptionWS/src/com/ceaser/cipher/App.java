package com.ceaser.cipher;

public class App {

	public static void main(String[] args) {
		
		String text = "My name is Kevin and I am a working as a software engineer at a multinational company and my main interests are algorithms and machine learning";
	
		CaesarCipher cipher = new CaesarCipher();
		
		String cipherText = cipher.encrypt(text, 10);
		System.out.println(cipherText);
		
		System.out.println(cipher.decrypt(cipherText, 10));
	}
}
