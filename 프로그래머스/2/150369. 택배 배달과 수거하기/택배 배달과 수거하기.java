import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        //그리디하게 풀어보자
        // 가장 먼 집부터 해결하는 것이 좋음 ??
       
        long result = 0;
        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<deliveries[i]; j++){
                dStack.push(i+1);
            }
            
            for(int j = 0; j<pickups[i]; j++){
                pStack.push(i+1);
            }
        }
        
        while(!dStack.isEmpty() && !pStack.isEmpty()) {
            int deliverIdx = dStack.peek();
            int pickIdx = pStack.peek();
            
            for(int i = 0; i<cap; i++){
                if(!dStack.isEmpty())
                    dStack.pop();
                if(!pStack.isEmpty())
                    pStack.pop();
            }
            
            result += Math.max(deliverIdx, pickIdx) * 2L;
        }
        
        //수거는 끝났지만 배달은 남은 경우
        while(!dStack.isEmpty()){
            int idx = dStack.peek();
            
            for(int i = 0; i<cap; i++){
                if(!dStack.isEmpty())
                    dStack.pop();
            }
            
            result += idx * 2L;
        }
        
        //배달은 끝났지만 수거는 남은 경우
        while(!pStack.isEmpty()){
            int idx = pStack.peek();
            
            for(int i = 0; i<cap; i++){
                if(!pStack.isEmpty())
                    pStack.pop();
            }
            
            result += idx * 2L;
        }
        
        return result;
    }
}