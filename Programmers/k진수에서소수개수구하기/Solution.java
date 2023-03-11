package Programmers.k진수에서소수개수구하기;

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while(n>0){
            sb.append(n%k);
            n = n/k;
        }


        StringTokenizer st = new StringTokenizer(sb.reverse().toString(), "0");

        int result = 0;
        boolean flag = true;

        while(st.hasMoreTokens()){
            String s = st.nextToken();

            long i = Long.parseLong(s);

            if(i!=1){
                for(long j = 2; j<=(int)Math.sqrt(i); j++){
                    if(i%j==0){
                        flag = false;
                        break;
                    }
                }

                if(flag)
                    result++;
            }
        }

        return result;
    }
}
