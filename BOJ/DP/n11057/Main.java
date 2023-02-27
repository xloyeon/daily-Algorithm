package BOJ.DP.n11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void dp(int n){
        int[] result = new int[n]; //n마다 결과값 저장
        int[][] counts = new int[10][n];

        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j = 0; j<10; j++){
                if(i==0) counts[j][i] = 1;
                else {
                    counts[j][i] = (result[i - 1] - temp + 10007)%10007;
                    temp =  (temp + counts[j][i - 1])%10007;
                }
            }

            int sum = 0;
            for(int j = 0; j<10; j++)
                sum += counts[j][i];
            result[i] = sum%10007;
        }

        System.out.println(result[n-1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp(n);
    }
}
