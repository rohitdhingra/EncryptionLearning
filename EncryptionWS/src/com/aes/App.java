package com.aes;

public class App {
    public static void main(String[] args) {
        AES aes = new AES();

        String text = "My name is Rohit Dhingra";
        String cipherText = aes.encrypt(text);
        System.out.println(cipherText);
        System.out.println(aes.decrypt(cipherText));
    }


}
