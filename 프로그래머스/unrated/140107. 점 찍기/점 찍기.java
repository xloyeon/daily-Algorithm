import java.util.*;

class Solution {
    public long solution(int k, int d) {
        //거리가 d를 넘는 경우
        //x값이 a*k일 때, 가능한 최대의 y값 구해서 그 안 까지 더하기
        
        long distance = (long)Math.pow(d, 2);
        long count = 0L;
        
        for(int i = 0; i<=d; i+=k){
            int temp = (int)Math.sqrt(distance - Math.pow(i, 2));
            temp = temp/k +1;
            count+= temp;
        }
        return count;
    }
}