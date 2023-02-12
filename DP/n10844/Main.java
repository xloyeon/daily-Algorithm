package DP.n10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[][] result;

    public static long dp(int idx, int k){
        if(idx ==1){
            return 1;
        }

        if(result[idx][k]==0){
            if(k == 0)
                result[idx][k] = dp(idx-1, 1);
            else if(k ==9)
                result[idx][k] = dp(idx-1, 8);
            else
                result[idx][k] = dp(idx-1, k-1) + dp(idx-1, k+1);
        }

        return result[idx][k]%1000000000;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long count = 0L;
        result = new long[n+1][10];

        for(int i = 1; i<10; i++) {
            count += dp(n, i);
            count %=1000000000;
        }
        System.out.println(count);
    }
}
