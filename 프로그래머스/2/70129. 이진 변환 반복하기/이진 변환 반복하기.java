import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(String s) {
        //0을 s에서 제거 -> s의 길이를 이진변환 = s
        
        int[] result = new int[2];
        int c = s.length();
        
        while(!s.equals("1")){
            result[0]++;    //이진변환 횟수 증가
            
            c = s.length();
            s = s.replace("0", ""); //0을 제거
    
            result[1] += c - s.length();
            c = s.length();
            
            
            s = Integer.toBinaryString(c);
    
        }
        
        return result;
        
    }
}