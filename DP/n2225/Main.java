package DP.n2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void Dp(int n, int k){
        //경우의 수 저장할 배열
        long[][] cases = new long[k+1][n+1];

        //정수 1개 더하기, 정수 2개 더하기 , ...
        for(int i = 1; i<=k; i++){
            //정수 1개를 더하는 경우 무조건 1
            if(i==1){
                for(int j = 0; j<=n; j++)
                    cases[i][j] = 1;
            }else{ //정수 2개 이상 구하는 경우(m을 n개의 정수로 더하는 경우)
                //(m = j, n = i), j를 i개의 정수로 더해 구하는 경우
                for(int j = 0; j<=n; j++){
                    long temp = 0L;

                    //(j, i)는 (j-1, i-1) + (j-2, i-1) + ... + (0, i-1)
                    for(int m = 0; m<=j; m++){
                        cases[i][j] = (cases[i][j] + cases[i-1][m])%1000000000;
                    }
                }
            }
        }
        System.out.println(cases[k][n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Dp(n, k);
    }
}
