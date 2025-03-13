package com.gcd;

public class App {
    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd_recursion(21,11));
        System.out.println(gcd.gcd_iteration(24,16));
    }
}
