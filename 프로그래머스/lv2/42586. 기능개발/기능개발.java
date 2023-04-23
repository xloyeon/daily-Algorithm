import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] counts = new int[progresses.length];
        int[] visited = new int[progresses.length];
        List<Integer> resultList = new ArrayList<>();
        
        //작업이 100프로 완료될 때의 날 계산
        for(int i = 0; i<progresses.length; i++){
            int progress = progresses[i];
            
            while(progress<100){
                progress += speeds[i];
                counts[i]++;
            }
        }
        
        for(int i = 0; i<counts.length; i++){
            if(visited[i] != 0) continue;
            
            int count = 1;
            
            visited[i] = 1;
                
            for(int j = i+1; j<counts.length; j++){
                if(visited[j] == 0 && counts[j]<=counts[i]){
                    visited[j] = 1;
                    count++;
                }else{
                    break;
                }
            }
            resultList.add(count);
        }
        
        int[] result = new int[resultList.size()];
        
        for(int i = 0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        
        return result;
        
    }
}