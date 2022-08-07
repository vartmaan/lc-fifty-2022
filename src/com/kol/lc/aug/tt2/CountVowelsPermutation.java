package com.kol.lc.aug.tt2;


public class CountVowelsPermutation {

    public int countVowelPermutation(int n) {

        long a= 1, e = 1, i = 1, o = 1, u =1;
        long MOD = 1000000007;
        long a2, e2, i2,o2,u2;

        for(int j = 2; j <= n; j++) {

            a2 = e;
            e2 = (a + i) % MOD;
            i2 = (a + e + o + u) % MOD;
            o2 = (i + u) % MOD;
            u2 = a;

            a = a2;
            e = e2;
            i = i2;
            o = o2;
            u = u2;
        }

        Long res =  (a+e+i+o+u) % MOD;

        return res.intValue();
    }


}
