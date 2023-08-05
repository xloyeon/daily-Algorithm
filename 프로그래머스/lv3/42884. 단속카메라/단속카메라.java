import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        //최소 한 번씩 만나게 하려면
        //진입지점 기준 정렬 -> 같으면 
        //뒤의 차량 이동 경로가 앞의 이동 경로에 포함이면 -18 -15
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        int start = -30001;
        int end = -30001;
        int count = 0;
        
        for(int[] route : routes) {
            if(route[1] <=end) {
                start = route[0];
                end = route[1];
            }else if(route[0] > end) {
                start = route[0];
                end = route[1];
                count++;
            }else {
                start = route[0];
            }
         }
        return count;
    }
}