import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] memo = new int[land.length][land[0].length];
        
        for(int i = 0; i<4; i++){
            memo[0][i] = land[0][i];
        }
        
        for(int i = 1; i<land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                for(int k = 0; k<land[0].length; k++){
                    if(j != k){
                        memo[i][j] = Math.max(memo[i][j], memo[i-1][k] + land[i][j]);
                    }
                }
            }
        }
        
        Arrays.sort(memo[land.length-1]);
        
        return memo[land.length-1][land[0].length-1];
        
        
    }
}