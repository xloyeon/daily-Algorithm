import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> removed = new Stack<>();
        
        for(int i = 0; i<cmd.length; i++){
            char c = cmd[i].charAt(0);
            
            if(c == 'U'){
                k -= Integer.parseInt(cmd[i].substring(2));
            } else if(c == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'C'){
                removed.add(k);
                n--;
                
                if(k == n) k--;
            }else {
                if(removed.pop()<=k)
                    k++;
                n++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            sb.append("O");
        }
        
        while(!removed.isEmpty()){
            int temp = removed.pop();
            sb.insert(temp, 'X');
        }
        
        return sb.toString();
    }
}