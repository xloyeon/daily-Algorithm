import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        //최대로 겹치는 부분을 찾기
        //처음부터 정렬해서 풀면 차례대로 ..?
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1]-o1[1];
            return o1[0] - o2[0];
        });
        
        int start = 0;
        int end = 0;
        int count = 0;
        
        for(int[] target : targets){
            int s = target[0];
            int e = target[1];
            
            //구간이 아예 겹치지 않으면
            if(s>=end){
                count++;
                start = s;
                end = e;
            }
            else if(e<=end){
                start = s;
                end = e;
            }else {
                start = s;
            }
        }
        
        return count;
    }
}