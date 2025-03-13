package com.vignere.cipher;

public class VigenereCipher {

	private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public String encrypt(String plainText, String key) {
		
		plainText = plainText.toUpperCase();
		// we make the algorithm case insensitive
		key = key.toUpperCase();
		String cipherText = "";
		
		// it represents the index for the key
		int keyIndex = 0;
		
		//we have to consider all the characters in the plain_text
		for(int i=0;i<plainText.length();++i) {
			char c = plainText.charAt(i);
			// number of shifts = (index of the character in the alphabet + 
			// index of the character in the key)%27
			int index = Math.floorMod(ALPHABET.indexOf(c) +
					ALPHABET.indexOf(key.charAt(keyIndex)), ALPHABET.length());
			
			cipherText += ALPHABET.charAt(index);
			//increment the key index because we consider the next letter in the key
			keyIndex++;
			
			if(keyIndex == key.length())
				keyIndex = 0;
		}
		
		return cipherText;
	}
	
	public String decrypt(String cipherText, String key) {
		
		cipherText = cipherText.toUpperCase();
		key = key.toUpperCase();
		
		String plainText = "";
		int keyIndex = 0;
		
		for(int i=0;i<cipherText.length();++i) {
			char c = cipherText.charAt(i);
			
			int index = Math.floorMod(ALPHABET.indexOf(c) -
					ALPHABET.indexOf(key.charAt(keyIndex)), ALPHABET.length());
			plainText += ALPHABET.charAt(index);
			
			keyIndex++;
			
			if(keyIndex == key.length())
				keyIndex = 0;
		}
		
		return plainText;
	}
}





