import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = sequence[0];
        int start = 0;
        int end = 0;
        int count = Integer.MAX_VALUE;
        int[] result = {0, Integer.MAX_VALUE};
        
        while(true){
            if(sum == k){
                if(end-start+1<count){
                    count = end-start+1;
                    result[0] = start;
                    result[1] = end;
                }else if(end-start+1 == count && start<result[0]){
                    result[0] = start;
                    result[1] = end;
                }
            }
            
            if(start == sequence.length && end == sequence.length) break;
            
            if(sum<=k && end<sequence.length){
                end++;
                if(end<sequence.length) sum+= sequence[end];
            }else{
                if(start<sequence.length) sum-=sequence[start];
                start++;
            }
            
        }
        
        
        return result;
    }
}