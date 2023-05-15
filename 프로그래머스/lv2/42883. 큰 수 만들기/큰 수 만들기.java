import java.util.*;

class Solution {
    public StringBuilder sb;
    public int count;
    
    public String solution(String number, int k) {
        //가장 큰 수 만들기 -> 순서는 지켜져야 함
        sb = new StringBuilder(number);
        count = 0;
        
        for(int i = 0; i<sb.length()-1; i++){
            int a = Integer.valueOf(sb.substring(i, i+1));
            int b = Integer.valueOf(sb.substring(i+1, i+2));
            
            if(a<b){
                sb.deleteCharAt(i);
                count++;
                if(count == k) return sb.toString();
                
                i = check(i, k);
            }
            
            if(count == k) return sb.toString();
        }
        
        while(count<k){
            sb.deleteCharAt(sb.length()-1);
            count++;
        }
        return sb.toString();
    }
    
    public int check(int i, int k){
        
        for(int j = i; j>0; j--){
            if(sb.charAt(j)>sb.charAt(j-1)){
                sb.deleteCharAt(j-1);
                count++;
            }else{
                return j-1;
            }
            
            if(count==k) return j-1;
        }
        return -1;
    }
}