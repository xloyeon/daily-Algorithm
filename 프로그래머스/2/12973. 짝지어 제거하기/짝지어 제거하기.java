import java.util.*;
import java.util.stream.*;

class Solution
{
    public int solution(String s)
    {
        // 문자열을 쌓으면서 찾기(이전 문자 백업)
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) { // 스택이 비어있다면 추가
                stack.push(s.charAt(i));
                continue;
            } 
            
            // 이전 문자와 같다면 제거
            char c = s.charAt(i);
            
            if (stack.peek() == c)
                stack.pop();
            else 
                stack.push(c);
        }
        
        if(stack.isEmpty())
            return 1;
        
        return 0;
    }  
}