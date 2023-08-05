import java.util.*;
import java.io.*;

public class Main {
    public static int[][] days;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        days = new int[n][2];
        
        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+1];
        
        for(int i = 0; i<n; i++){
            if(i + days[i][0] <= n){    //마지막 상담일자가 범위 안이면
                //현재 시작하는 상담 마지막에 받을 수 있는 max
                dp[i+days[i][0]] = Math.max(dp[i+days[i][0]], dp[i] + days[i][1]);
            }
            
            //현재 날짜에 상담해서 얻을 수 있는 수익은 이전의 최대값으로 갱신
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        
        System.out.println(dp[n]);
    }
}