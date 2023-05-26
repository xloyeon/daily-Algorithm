import java.util.*;

class Solution {
    public int solution(String s) {
        //문자열에서 같은 값이 연속해 나타나면 문자 개수와 반복되는 값으로 표현
        //자르는 단위는 2부터 시작~s의 길이-1
        //초기값은 처음 s의 길이
        int min = s.length();
        
        //간격 늘리기 -> i
        for(int i = 1; i<=s.length()/2; i++){
            int len = 0;
            
            for(int j = 0; j+i<=s.length();){
                int idx = j+i;
                String before = s.substring(j, idx);
                int count  = 1;
                
                while(idx + i<=s.length() && s.substring(idx, idx+i).equals(before)){
                    count++;
                    idx += i;
                }
                
                if(count == 1) len += i;
                else len += String.valueOf(count).length() + i;
                
                j = idx;
            }
            
            if(s.length()%i != 0) len += s.length()%i;
            min = Math.min(min, len);
            
        }
        
        return min;
    }
}