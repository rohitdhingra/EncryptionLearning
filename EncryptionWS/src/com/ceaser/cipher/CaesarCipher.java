package com.ceaser.cipher;

public class CaesarCipher {
	
	// there are 26+1 characters
	private String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public String encrypt(String plainText, int key) {
		
		String cipherText = "";
		// we make the algorithm case insensitive
		plainText = plainText.toUpperCase();
		
		// consider all the letters in the plain_text
		for(int i=0;i<plainText.length();i++) {
			char character = plainText.charAt(i);
			// find the numerical representation (index) associated with 
			// that character in the alphabet
			int charIndex = ALPHABET.indexOf(character); 
			// Caesar encryption is just a simple shift of characters according to the key
			// use modular arithmetic to transform the values within the range 
			// [0,num_of_letters_in_alphabet]
			int encryptedIndex = Math.floorMod(charIndex+key, ALPHABET.length());
			// keep appending the encrypted character to the cipher_text
			cipherText += ALPHABET.charAt(encryptedIndex);
		}
		
		return cipherText;	
	}
	
	public String decrypt(String cipherText, int key) {
		
		//the input cipherText is already upper case
		String plainText = "";
		
		for(int i=0;i<cipherText.length();++i) {
			char character = cipherText.charAt(i);
			int charIndex = ALPHABET.indexOf(character);
			int decryptedIndex = Math.floorMod(charIndex-key, ALPHABET.length());
			plainText += ALPHABET.charAt(decryptedIndex);
		}
		
		return plainText;
	}
}







