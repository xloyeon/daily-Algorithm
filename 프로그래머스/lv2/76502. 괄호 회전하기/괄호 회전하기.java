import java.util.*;

class Solution {
    public List<String> left = Arrays.asList("(", "[", "{");
    public List<String> right = Arrays.asList(")", "]", "}");
    
    public boolean check(String s){
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            String temp = s.substring(i, i+1);
            
            if(stack.isEmpty()){
                if(right.contains(temp))
                    return false;
                else {
                    stack.push(temp);
                    continue;
                }
            }
            
            if(right.contains(temp) && left.contains(stack.peek())){
                if(right.indexOf(temp) == left.indexOf(stack.peek())){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(temp);
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    public int solution(String s) {
        int answer = 0;     //올바른 괄호 문자열의 개수
        
        //일단 s를 회전
        for(int i = 0; i<s.length(); i++){
            s = s.substring(1)+s.substring(0, 1);
            if(check(s)) answer++;
        }
        return answer;
    }
}