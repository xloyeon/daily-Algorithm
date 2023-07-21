import java.util.*;

class Solution {
    //n시간 남음 -> n만큼 처리할 수 있음
    //각 work에 대해 총 n만큼을 뺌 -> work의 제곱의 합이 최소가 되어야 함
    
    public long solution(int n, int[] works) {
        long result = 0L;

        //내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0 ; i < works.length ; i++) {
            pq.add(works[i]);
        }

        while(n > 0) {
            int temp = pq.poll();
            
            if(temp==0)
                break;
            
            if(temp>=1)
                pq.add(temp-1);
            n--;
        }

        while (!pq.isEmpty()) {
            int temp = pq.poll();
            result += Math.pow(temp, 2);
        }

        return result;
    }
}