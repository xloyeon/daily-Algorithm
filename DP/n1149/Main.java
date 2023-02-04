package DP.n1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] charge;
    static int[][] store;

    public static void Dp(int n){

        for(int i = 0; i<3; i++){
            store[i][0] = charge[i][0];
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<3; j++){
                int finalJ = j;
                int temp =  comparate(i, j);
                store[j][i] = temp + charge[j][i];
            }
        }

        int min = store[0][n-1];

        for(int i = 1; i<3; i++)
            if(min>store[i][n-1]) min = store[i][n-1];

        System.out.println(min);
    }

    public static int comparate(int i, int j){
        if(j ==0){
            return Math.min(store[1][i-1], store[2][i-1]);
        }else if(j==1){
            return Math.min(store[0][i-1], store[2][i-1]);
        }else{
            return Math.min(store[0][i-1], store[1][i-1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        charge = new int[3][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                charge[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        store = new int[3][n];
        Dp(n);
    }
}
