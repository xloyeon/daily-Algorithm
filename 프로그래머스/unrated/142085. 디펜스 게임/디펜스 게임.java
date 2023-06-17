import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        //K를 적이 많은 라운드에서 사용하면 가능 ..?
        //만약 더 뺄 수 없으면 이전에 값 들 중 가장 큰 값을 무적권 사용하고 계산
        //매번 정렬 ? -> 우선순위 큐 사용해서 큰 값 구하기
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int rest = n;   //남은 병사 수
        
        for (int i = 0; i < enemy.length; i++) {
            //지금 병사 수가 이전 적들보다도 큰 값일 수 있으므로 먼저 넣고 확인
            rest -= enemy[i];
            q.add(enemy[i]);
            
            if(rest<0){
                //이전 적 수 중 가장 큰 값을 무적권 사용했다고 하기
                if(k>0 && !q.isEmpty()){
                    rest += q.poll();
                    k--;
                }else{
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}