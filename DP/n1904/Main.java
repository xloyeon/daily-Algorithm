package DP.n1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 15746;
    static int[] result;

    public static int dp(int n){
        if(result[n] == 0){
            if(n<=2) return n;
            else
                result[n] = (dp(n-1)+ dp(n-2)) % MOD;
        }
        return result[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new int[n+1];

        System.out.println(dp(n));
    }
}
