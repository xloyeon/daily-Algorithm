import java.util.*;

class Solution {
    public String solution(int n) {
        int temp = 3;
        int idx = 2;
        
        while(n>temp){
            temp += Math.pow(3, idx);
            idx++;
        }
        
        //8일 때, idx = 3
        //13일 떼, idx = 4 111
        StringBuilder sb = new StringBuilder();
        
        
        
        int start = ((int)(temp-Math.pow(3, idx-1))+1); 
        int m = n-start;
        int pow = idx-2;

        for(int i=0; i<idx-1; i++){
            int div = (int)(m/Math.pow(3, pow));

            if(div == 2) sb.append(4);
            else if(div == 1) sb.append(2);
            else sb.append(1);

            m %= Math.pow(3, pow);
            pow--;
        }

        return sb.toString();
    }
}