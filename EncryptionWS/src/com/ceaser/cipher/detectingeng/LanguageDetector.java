package com.ceaser.cipher.detectingeng;

import java.util.List;

public class LanguageDetector {
	
	private FileProcessor fileProcessor;
	// we store the English words in an array (ArrayList)
	private List<String> englishWords;
	
	public LanguageDetector() {
		this.fileProcessor = new FileProcessor();
		this.englishWords = fileProcessor.getWords();
	}

	// counts the number of English words in a given text
	private int countEnglishWordsInText(String text) {
		//upper case letters are needed
		text = text.toUpperCase();
		
		// transform the text into a list of words (split by spaces)
		String[] words = text.split(" ");
		// matches counts the number of English words in the text
		int matches = 0;
		
		for(String s : words)
			if(englishWords.contains(s))
				matches++;
		
		return matches;
	}
	
	public boolean isEnglish(String text) {
		// number of English words in a given text
		int matches = countEnglishWordsInText(text);
		
		// you can define your own classification algorithm
		// in this case the assumption: if 60% of the words in 
		// the text are English words then it is an English text
		if( (float) matches / text.split(" ").length * 100 >= 60)
			return true;
		
		return false;
	}
}
