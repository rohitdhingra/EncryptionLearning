package org.example.ecc;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        ECC ecc = new ECC(3,7);

        Point generator = new Point(-2,1);
//        System.out.println(ecc.pointAddition(generator,generator));
//        System.out.println(ecc.doubleAndAdd(100,generator));
        Random random = new Random();
        int a = random.nextInt(10000);
        int b = random.nextInt(10000);

        Point alicePublicKey = ecc.doubleAndAdd(a,generator);
        Point bobPublicKey = ecc.doubleAndAdd(b,generator);

        Point aliceSecretKey = ecc.doubleAndAdd(a,bobPublicKey);
        Point bobSecretKey = ecc.doubleAndAdd(b,alicePublicKey );

        System.out.println(aliceSecretKey);
        System.out.println(bobSecretKey);


    }
}
