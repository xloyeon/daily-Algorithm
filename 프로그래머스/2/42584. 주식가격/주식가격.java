import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        //스택으로 풀려면?
        // 지금 배열의 수보다 스택의 수가 더 크면? >> 인덱스끼리 차이 비교해서 저장
        // 지금 배열의 수가 스택의 수보다 더 크면? >> 스택에 쌓기
        
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i<prices.length; i++){
            
            //스택 수가 더 크면 
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek(); 
                stack.pop();
            }
            //현재값 넣기
            stack.push(i);
        }
        
        //스택 비우기
        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek()-1;
            stack.pop();
        }
        return answer;
    }
}