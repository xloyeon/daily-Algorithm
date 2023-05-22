import java.util.*;

class Solution {
    public StringBuilder sb;
    public int count;
    
    public String solution(String number, int k) {
        //가장 큰 수 만들기 -> 순서는 지켜져야 함
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<number.length(); i++){
            int n = Integer.valueOf(String.valueOf(number.charAt(i)));
        
            while(!stack.isEmpty() && stack.peek()<n && count<k){
                stack.pop();
                count++;
            }
            
            stack.push(n);
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        while(count<k){
            sb.deleteCharAt(0);
            count++;
        }
        
        return sb.reverse().toString();
    }
}