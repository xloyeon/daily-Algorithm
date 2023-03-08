package Programmers.짝지어제거하기;

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            String temp = String.valueOf(s.charAt(i));

            if(!stack.isEmpty() && stack.peek().equals(temp)){
                stack.pop();
            }else{
                stack.push(temp);
            }
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }
}