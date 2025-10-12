import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int[] servers = new int[players.length];
        
        int result = 0;     //증설횟수
        
        for(int i = 0; i<players.length; i++){
            int needs = players[i]/m;
            
            while(servers[i]<needs){
                for(int j  = 0; j<k; j++){
                    if(i+j<servers.length)
                        servers[i+j]++;
                }
                
                result++;
            }
            
        }
        
        return result;
    }
}