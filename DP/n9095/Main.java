package DP.n9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] cases;

    public static int dp(int n){
        if(n == 1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }
        return dp(n-1) + dp(n-2) + dp(n-3);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        cases = new int[t+1];

        for(int i = 0; i<t; i++){
            System.out.println(dp(Integer.parseInt(br.readLine())));
        }
    }
}
