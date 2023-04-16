import java.util.*;

class Solution {
    
    public long solution(int n) {
        int[] result = new int[n];
        
        for(int i = 0; i<n; i++){
            if(i==0) result[i] = 1;
            else if(i==1) result[i] = 2;
            else{
                result[i] = (result[i-1] + result[i-2])%1234567;
            }
        }
        return result[n-1];
    }
}