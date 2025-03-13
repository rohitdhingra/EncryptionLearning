package com.gcd;

public class ExtendedEuclideanAlgorithm {
    public int[] egcd(int a, int b)
    {
        if(a==0)
        {
            return new int[]{b,0,1};
        }
        int[] values = egcd(b%a, a);

        int gcd = values[0];
        int x1 = values[1];
        int y1 = values[2];

        int x = y1 -(b/a) *x1;
        int y = x1;

        return new int[]{gcd,x,y};
    }
}
