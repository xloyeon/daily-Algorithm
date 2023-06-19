import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        //x가 0일 때부터 x가 r2일때까지
        //y^2이 r1^2 이상, r2^2 이하
        
        long result = 0L;
        
        long areaA= (long) Math.pow(r1, 2);
        long areaB = (long) Math.pow(r2, 2);
        
        for(int i = 1; i<=r2; i++){
            
            long rangeA = areaA - (long) Math.pow(i, 2);
            long rangeB = areaB - (long) Math.pow(i, 2);
            
            long y1 = (long)Math.sqrt(rangeA);
            long y2 = (long) Math.sqrt(rangeB);
            
            if(Math.sqrt(rangeA)%1 == 0 || i>r1) {
                result += 1;
            }
            result +=(y2-y1);
        }
        
        return result*4;
    }
}