import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        //마지막 블록 100개
        //각 구간에는 가장 큰 블록만 남음
        //약수 중에 가장 큰 것이 남음
        
        //구간 결과 담을 배열
        int length = (int)(end-begin);
        int[] result = new int[length+1];
        
        
        for(long i = begin; i<=end; i++){
            //결과 배열의 인덱스
            int idx = (int)(i-begin);
            
            int last = (int)Math.sqrt(i);
            
            for(int j = 2; j<=last; j++){
                
                if(i%j == 0){
                    int temp = (int)(i/j);
                    
                    if(temp<=10000000){
                        result[idx] = temp;
                        break;
                    }else{
                        result[idx] = j;
                    }
                }
            }
            
            if(i!=1 && result[idx] == 0)
                result[idx] = 1;
        }
        
        return result;
    }
}