import java.util.*;

class Solution {
    public int solution(String s) {
       
        int answer = 0;
        
        List<String> leftBrackets = Arrays.asList(new String[]{"[", "(", "{"});
        List<String> rightBrackets = Arrays.asList(new String[]{"]", ")", "}"});
        
        //괄호 회전시키기
        for(int i = 0; i<s.length(); i++){
            s = s.substring(1) + s.substring(0, 1);
            
            //회전한 문자열이 올바른 괄호 문자열인지 확인하기
            Stack<String> stack = new Stack<>();
            
            for(int j = 0; j<s.length(); j++){
                //스택이 비어있다면? 무조건 push
                //좌괄호라면 ? 무조건 push
                //우괄호라면 ? 스택의 상단이 같은 인덱스인지 보고 pop
                String k = s.substring(j, j+1);
                
                if(stack.isEmpty() || leftBrackets.contains(k)){
                    stack.push(k);
                    continue;
                }
                
                if(leftBrackets.contains(stack.peek()) && leftBrackets.indexOf(stack.peek()) == rightBrackets.indexOf(k)){
                    stack.pop();
                }else{
                    stack.push(k);
                }
            }
            
            if(stack.isEmpty())
                answer ++;            
        }
        
        return answer;
    }
}