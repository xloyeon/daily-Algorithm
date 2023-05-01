import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        
        for(int i = 0; i<prices.length-1; i++){
            int count = 1;
            
            for(int j = i+1; j<prices.length; j++){
                if(prices[i]>prices[j]){
                    result[i] = count;
                    break;
                }else{
                    count++;
                }
            }
            
            if(result[i] == 0) result[i] = prices.length-i-1;
        }
        
        return result;
    }
}