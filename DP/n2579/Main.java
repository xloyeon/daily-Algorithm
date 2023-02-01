package DP.n2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static int[] stairs;
    public static int[] maxValues;
    public static Stack<Integer> stack;

    public static int dp(int index){
        if(index == 0){
            return 0;
        }

        if(maxValues[index]>0){
            return maxValues[index];
        }

        if(index>2){
            int first = dp(index-3) + stairs[index-1];
            maxValues[index] = Math.max(dp(index-2), first) + stairs[index];
        }else {
            maxValues[index] = stairs[index-1] + stairs[index];
        }

        return maxValues[index];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stairs = new int[n+1];
        maxValues = new int[n+1];

        for(int i = 1; i<n+1; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(n));
    }
}
