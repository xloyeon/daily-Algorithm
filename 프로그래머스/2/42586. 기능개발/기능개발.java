import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //큐에 무엇을 저장? => 각 progress 별 100에 도달할 때까지 남은 일자
        // (100-progress)/speed 만큼 => 나머지 있으면 +1
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<progresses.length; i++){
            int x = (100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i] + 1;
            q.add(x);
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        while(!q.isEmpty()){
            int x = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && x>=q.peek()){
                q.poll();
                cnt++;
            }
            
            resultList.add(cnt);
        }
        
        int[] answer = new int[resultList.size()];
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}