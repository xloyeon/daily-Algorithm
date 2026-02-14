import java.util.*;

class Solution {
    public int alp_goal = 0;
    public int cop_goal = 0;
    
    public int solution(int alp, int cop, int[][] problems) {
        
        for(int i = 0; i<problems.length; i++){
            alp_goal = Math.max(alp_goal, problems[i][0]);
            cop_goal = Math.max(cop_goal, problems[i][1]);
        }
       
        // dp[a][c] 는 alp가 a, cop가 c에 도달하는데 걸리는 최소 시간
        int[][] dp = new int[alp_goal+1][cop_goal+1];
        
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);  //일단 최대값으로 채워넣기
        }
        
        alp = Math.min(alp, alp_goal);
        cop = Math.min(cop, cop_goal);
        
        dp[alp][cop] = 0;
        
        for(int a = alp; a<=alp_goal; a++){
            for(int c = cop; c<= cop_goal; c++){
                
                if(a < alp_goal){
                    dp[a+1][c] = Math.min(dp[a+1][c], dp[a][c]+1);
                }
                
                if(c < cop_goal){
                    dp[a][c+1] = Math.min(dp[a][c+1], dp[a][c] + 1);
                }
                
                for(int[] p : problems){
                    if(a >= p[0] && c >= p[1]){
                        int solvedA = Math.min(alp_goal, a + p[2]);
                        int solvedC = Math.min(cop_goal, c + p[3]);
                        
                        dp[solvedA][solvedC] = Math.min(dp[solvedA][solvedC], dp[a][c] + p[4]);
                    }
                }
            }
        }
        
        return dp[alp_goal][cop_goal];
    }
}