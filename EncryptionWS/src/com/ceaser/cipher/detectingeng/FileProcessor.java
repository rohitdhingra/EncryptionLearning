package com.ceaser.cipher.detectingeng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

	private List<String> words;
	
	public FileProcessor() {
		this.words = new ArrayList<>();
		getData();
	}

	private void getData() {
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(new File("/Users/rohitdhingra/Downloads/EncryptionWS/src/com/ceaser/cipher/detectingeng/english_words.txt"));
			bufferedReader = new BufferedReader(fileReader);
			
			String line = "";
			
			while((line=bufferedReader.readLine())!=null) {
				words.add(line.toUpperCase());	
			}
			
			fileReader.close();
			bufferedReader.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public List<String> getWords() {
		return this.words;
	}
}
