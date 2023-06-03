import java.util.*;

class Solution {
    public int solution(int storey) {
        // storey에서 0층으로 가는 최소값
        
        //절댓값이 10인 것 -> storey보다 작은 것들로?
        int num = 0;
        
        while(storey!=0){
            int n = storey%10;
            
            if(n>=6){
                num += 10 - n;
                storey += 10-n;
            }else if(n == 5 && (storey/10)%10 >=5){
                num += 10-n;
                storey += 10-n;
            }else{
                num += n;
                storey /= 10;
            }
        
        }
        return num;
    }

}