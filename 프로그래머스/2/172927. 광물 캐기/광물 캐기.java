import java.util.*;

class Solution {
    public int[] picks;
    public String[] minerals;
    public int result = Integer.MAX_VALUE;
    public int maxUse;
   
    public int[][] consumption = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    public int matchConsumption(int idx){
        if(minerals[idx].equals("iron"))
            return 1;
        else if(minerals[idx].equals("stone"))
            return 2;
        return 0;
    }
    
    public void dfs(int pick, int idx, int use, int consume){ //현재 사용 중인 곡괭이, 남은 사용개수, 현재 캐는 광물
        if(idx == minerals.length || idx>=maxUse){
            result = Math.min(result, consume);
            return;
        }
        
        int c = matchConsumption(idx);
        
        if(use == 5){
            for(int i = 0; i<picks.length; i++){
                if(picks[i]>0){
                    picks[i]--;
                    dfs(i, idx+1, 1, consume + consumption[i][c]);
                    picks[i]++;
                }
            }
        }else {
            dfs(pick, idx+1, use+1, consume+consumption[pick][c]);
        }
    }
    
    
    public int solution(int[] picks, String[] minerals) {
        // 다이아, 철, 돌 곡괭이의 개수 => picks
        // 캐야 할 다이아, 철 돌의 개수 => minerals
        
        //최소한의 피로도로 작업하려면 모든 
        this.picks = picks;
        this.minerals = minerals;
        
        // 곡괭이를 모두 사용하더라도 광물을 모두 캘 수 없는 경우가 있음
        maxUse = (picks[0] + picks[1] + picks[2]) * 5;
        
        for(int i = 0; i<picks.length; i++){
            if(picks[i] > 0){
                picks[i]--;
                int c = matchConsumption(0);
                dfs(i, 1, 1, consumption[i][c]);
                picks[i]++;
            }
        }
        return result;
    }
}