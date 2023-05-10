import java.util.*;

class Solution {
    public int[] memo;
    public int n;
    public int x;
    
    public int solution(int x, int y, int n) {
        memo = new int[y+1];
        
        for(int i = x+1; i<=y; i++){
            int temp = 0;
            int temp1 = Integer.MAX_VALUE;
            int temp2 = Integer.MAX_VALUE;
            int temp3 = Integer.MAX_VALUE;
            
            if(i%3 == 0 && i/3>=x){
                temp1 = memo[i/3];
            }
            if(i%2 == 0 && i/2>=x){
                temp2 = memo[i/2];
            }
            if(i-n>=x){
                temp3 = memo[i-n];
            }
            
            temp = Math.min(temp1, temp2);
            temp = Math.min(temp, temp3);
            
            if(temp<Integer.MAX_VALUE){
                memo[i] = temp + 1;
            }else{
                memo[i] = Integer.MAX_VALUE;
            }
        }
        
        if(memo[y]<Integer.MAX_VALUE){
            return memo[y];
        }
        return -1;
        
    }  
}