import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 큐의 합이 같을 수 없는 경우는? 원래대로 다시 돌아온 경우 
        // 두 큐의 합을 순차로 돌면서 맞춰야 할까? 그렇다면 순서는?
        // 큐 a, 큐 b가 있을 때 더 작은 쪽으로 수를 옮겨야 한다
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0L;
        long sum2 = 0L;
        
        int count = 0;
        
        for(int i =0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i =0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        int limit = queue1.length* 3 + queue2.length*3;
        
        while(count<=limit){
            
            if(sum1 == sum2) return count;
            
            if(sum1 < sum2){
                int x = q2.poll();
                q1.add(x);
                sum1 += x;
                sum2 -= x;
            }else{
                int x = q1.poll();
                q2.add(x);
                sum1 -= x;
                sum2 += x;
            }
            
            count++;
            
        }
        
        return -1;
    }
}