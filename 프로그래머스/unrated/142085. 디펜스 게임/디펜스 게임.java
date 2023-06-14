import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        //K를 적이 많은 라운드에서 사용하면 가능 ..?
        //많은 ROUND K개 제외한 다음, 병사를 소모하며 확인
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            q.add(enemy[i]);
            
            if (q.size() > k)
                n -= q.poll();
            
            if (n < 0)
                return i;
        }
        
        return enemy.length;
    }
}