package Programmers.괄호회전하기;

import java.util.*;

public class Solution {
    public List<String> left = Arrays.asList("(", "{", "[");
    public List<String> right = Arrays.asList(")", "}", "]");

    public boolean isRightBracket(StringBuffer sb){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i<sb.length(); i++){
            String bracket = String.valueOf(sb.charAt(i));

            if(stack.isEmpty()){
                stack.push(bracket);
                continue;
            }

            String last = stack.peek();

            if(left.contains(last) && right.contains(bracket)){
                if(left.indexOf(last) == right.indexOf(bracket)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(bracket);
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }

    public int solution(String s) {
        //한칸씩 회전시키면서 보기
        //왼쪽 괄호 없는데 오른쪽 괄호가 들어오려고 함 -> x
        //왼쪽 괄호 있으면 상쇄됨
        StringBuffer sb = new StringBuffer(s);

        int result = 0;

        for(int i = 0; i<sb.length(); i++){
            String del = String.valueOf(sb.charAt(0));
            sb.delete(0, 1);
            sb.append(del);

            if(isRightBracket(sb)){
                result++;
            }
        }

        return result;
    }
}
