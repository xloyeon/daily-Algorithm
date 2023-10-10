import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> removed = new Stack<>();
        
        for(int i = 0; i<cmd.length; i++){
            char c = cmd[i].charAt(0);
            
            if(c == 'U'){
                k -= Integer.parseInt(cmd[i].substring(2)); //숫자만큼 위로
            } else if(c == 'D') {
                k += Integer.parseInt(cmd[i].substring(2)); //숫자만큼 아래로
            }else if(c == 'C'){
                removed.add(k); //현재 인덱스 위치를 삭제함
                n--;    //표의 크기를 줄임
                
                if(k == n) k--; //마지막행 삭제면 위치를 하나 줄임
            }else {
                if(removed.pop()<=k)    //이전이 삭제면 위치도 조정해야, 아니면 그대로
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