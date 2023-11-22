import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long start = 0;
        long end = (long)times[times.length-1]*n;
        long mid = (start+end)/2;
        long result = 0;
        
        
        while(start<=end){
            mid = (start+end)/2;
            long sum = 0;
            
            for(int i = 0; i<times.length; i++){
                sum += mid/times[i];
            }
            
            if(sum<n){
                start = mid+1;
            }else{
                end = mid-1;
                result = mid;
            }
        }
        return result;
    }
}