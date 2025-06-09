import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        //현재 다리에 올라간 트럭의 무게
        int currentWeight = 0;
        
        int time = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i<bridge_length; i++){
            queue.add(0);
        }
    
        
        for(int i = 0; i<truck_weights.length; i++){
            currentWeight -= queue.poll();   //앞에 완전히 빼기
            
            if(currentWeight + truck_weights[i] > weight){
                queue.add(0);
                i--;
            }else{
                currentWeight += truck_weights[i];
                queue.add(truck_weights[i]);
            }
            
            time++;
        }
        
        
        while(!queue.isEmpty()){
            queue.poll();
            time++;
        }
        
        return time;
    }
}