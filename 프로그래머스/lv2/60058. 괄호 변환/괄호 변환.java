import java.util.*;

class Solution {
    
    public int splitBrackets(String p){
        int left = 0;
        int right = 0;
        
        for(int i = 0; i<p.length(); i++){
            String temp = p.substring(i, i+1);
            
            if(temp.equals("("))
                left++;
            else
                right++;
            
            if(left == right) return i;
        }
        return p.length();
    }
    
    public boolean check(String u){
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i<u.length(); i++){
            String temp = u.substring(i, i+1);
            
            //'('일 때는 스택이 비어있으면 넣지 않고 자름, 단 i = 0일 경우 제외
            if(temp.equals("("))
                stack.push("(");
            else if(stack.isEmpty()) 
                return false;
            else
                stack.pop();
        }
        
        if(stack.isEmpty()) return true;
        else return false;
        
    
    }
    
    public String recursion(String p){
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if(p.length()==0) return p;
        
        int splitIdx = splitBrackets(p);
        String u = p.substring(0, splitIdx+1);
        String v = p.substring(splitIdx+1);
        
        if(check(u))
            return u + recursion(v);
        else {
            return "(" + recursion(v) + ")" + reverseBrackets(u.substring(1, u.length()-1));
        }
    }
    
    public String reverseBrackets(String s){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            String temp = s.substring(i, i+1);
            if(temp.equals("(")) sb.append(")");
            else sb.append("(");
        }
        
        return sb.toString();
    }
    
    public String solution(String p) {
        return recursion(p);
    }
}