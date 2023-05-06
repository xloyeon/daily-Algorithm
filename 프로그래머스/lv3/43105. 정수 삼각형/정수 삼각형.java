import java.util.*;

class Solution {
    public int[][] result;
    public int[][] triangle;
    
    public int dp(int level, int idx){
        if(idx<0 || idx>= result[level].length)
            return 0;
        
        if(result[level][idx] != 0)
            return result[level][idx];
        
        
        return result[level][idx] = Math.max(dp(level-1, idx-1), dp(level-1, idx)) + triangle[level][idx];
    }
    
    public int solution(int[][] triangle) {
        result = new int[triangle.length][];
        this.triangle = triangle;
        
        for(int i = 0; i<triangle.length; i++){
            result[i] = new int[triangle[i].length];
        }
        
        
        result[0][0] = triangle[0][0];
        
        int max = 0;
        
        for(int i = 0; i<triangle[triangle.length-1].length; i++){
            max = Math.max(max, dp(triangle.length-1, i));
        }
        
        return max;
        
    }
}