package BOJ.DP.n1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void Dp(int n){
        long[][] result = new long[n+1][3];

        for(int i = 0; i<3; i++)
            result[1][i] = 1;

        //i는 세로
        for(int i = 2; i<=n; i++){
            //j는 가로
            for(int j = 0; j<3; j++){
                if(j==0){
                    result[i][j] = Arrays.stream(result[i-1]).sum()%9901;
                }else{
                    long sum = Arrays.stream(result[i-1]).sum();
                    result[i][j] = (sum -result[i-1][j])%9901;
                }
            }
        }
        System.out.println(Arrays.stream(result[n]).sum()%9901);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Dp(n);
    }
}
