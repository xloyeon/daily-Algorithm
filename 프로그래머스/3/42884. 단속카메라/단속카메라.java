import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        //가장 많은 차가 겹치는 지점에 설치하는 것이 중요?
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        
        int camera = -30001;
        int result = 0;
        
        for(int[] route : routes){
            if(route[0]>camera || route[1]<camera){
                camera = route[1];
                result++;
            }
        }
        
        return result;
    }
}