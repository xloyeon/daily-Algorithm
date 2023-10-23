import java.io.*;
import java.util.*;

public class Main {
    public static int[] dp;
    
    public static int dp(int n){
        if(n == 1 || n == 3)
            return dp[1] = 2;
        else if(n == 2 || n == 4)
            return dp[2] = 1;
        
        
        if(dp[n] !=0) return dp[n];
        
        if(dp(n-1) == 2 || dp(n-3) == 2 || dp(n-4) == 2)
            return dp[n] = 1;
        else
            return dp[n] = 2;
    }
    
    public static void main(String[] args) throws Exception {
        //남은 돌이 1이면 -> 창영 이김
        //남은 돌이 2이면 -> 상근 이김
        //남은 돌이 3이면 -> 창영 이김
        //남은 돌이 4이면 -> 상근 이김
        //남은 돌이 5이면 -> ... -> 상근 우선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        dp = new int[N+1];
        
        if(dp(N) == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
        
    }
}