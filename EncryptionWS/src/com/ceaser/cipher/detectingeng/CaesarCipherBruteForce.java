package com.ceaser.cipher.detectingeng;

public class CaesarCipherBruteForce {
	
	private String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private LanguageDetector languageDetector;
	
	public CaesarCipherBruteForce() {
		this.languageDetector = new LanguageDetector();
	}
	
	public void crack(String cipherText) {
		
		// we try all the possible key values so the size of the ALPHABET
		// thats why Caesar cipher is weak: 27 possible encryptions
		// IT MAKES 27 ITERATIONS !!!
		for(int key=0;key<ALPHABET.length();++key) {
			
			// reinitialize this to be an empty string
			String plainText = "";
			
			// we just have to make a simple Caesar decryption
			for(int i=0;i<cipherText.length();++i) {
				char character = cipherText.charAt(i);
				int charIndex = ALPHABET.indexOf(character);
				int decryptedIndex = Math.floorMod(charIndex-key, ALPHABET.length());
				plainText += ALPHABET.charAt(decryptedIndex);
			}
			
			if(languageDetector.isEnglish(plainText))
				System.out.format("Caesar-cipher with %s key the result is: %s%n", 
					key, plainText);
		}
		
	}
}







