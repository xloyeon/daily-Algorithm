import java.util.*;

class Solution {
    public String solution(int n) {
        
        int temp = 3;   //3은 미리 더해놓기
        int idx = 2;
        
        while(n>temp){
            temp += Math.pow(3, idx);   //3의 제곱수만큼 늘어남
            idx++;
        }
        
        //8일 때, idx = 3
        //13일 때, idx = 4 111
        StringBuilder sb = new StringBuilder();
        
        
        int start = ((int)(temp-Math.pow(3, idx-1))+1); //현재수(temp)에서 전단계(떨어지는 수)
        int m = n-start;    //떨어지지 않는 만큼(13일 때 0)
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