package DP.n9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] result = new long[101];

    public static long dp(int n){
        if (result[n] != 0) {
           return result[n];
        }

        if(n>=1 && n<=3)
            result[n] = 1;
        else if(n==4 || n==5)
            result[n] = 2;
        else
            result[n] = dp(n-5) + dp(n-1);
        return result[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }
}
