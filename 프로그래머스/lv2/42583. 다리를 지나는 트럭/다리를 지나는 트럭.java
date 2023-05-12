import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        
        int idx = 0;
        int sum = 0; //다리에 올라간 트럭의 총 무게
        int time = 0; //걸린 시간
        
        while(q.size()<bridge_length){
            q.add(0);
        }
        
        while(idx<truck_weights.length){
            if(q.size() == bridge_length){
                sum -= q.poll();
                time++;
            }
            
            //end 먼저 확인
            if(q.size()<bridge_length){
                if(sum+truck_weights[idx]<=weight){
                    sum+= truck_weights[idx];
                    q.add(truck_weights[idx]);
                    idx++;
                }else{
                    q.add(0);
                }
            }
            
        }
        
        while(!q.isEmpty()){
            int x = q.poll();
            sum -= x;
            time++;
        }
        
        return time;
    }
}