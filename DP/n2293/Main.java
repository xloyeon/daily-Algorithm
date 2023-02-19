package DP.n2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] coin;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        result = new int[k+1];
        result[0] = 1;

        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<n; i++){
            for(int j = coin[i]; j<=k; j++){
                result[j] = result[j] + result[j-coin[i]];
            }
        }

        System.out.println(result[k]);
    }
}
