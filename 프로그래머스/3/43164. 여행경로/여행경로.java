import java.util.*;

class Solution {
    public String[][] tickets;
    public int[] visited;
    public String[] result;
    
    public int dfs(String from, int idx){
        if(idx == result.length){
            for(int i = 0; i<visited.length; i++){
                int k = visited[i];
                if(k == 0) continue;
                result[k] = tickets[i][1];
            }
            return 1;
        }
            
            
        for(int i = 0; i<tickets.length; i++){
            if(visited[i] != 0)
                continue;
            
            if(tickets[i][0].equals(from)){
                visited[i] = idx;
                if(dfs(tickets[i][1], idx+1) == 1)
                    return 1;
                visited[i] = 0;
            }
        }
        return 0;
    }
    public String[] solution(String[][] tickets) {
        /* 1. 주어진 티켓을 모두 이용한 여행 경로를 return
         * 2. 만약, 가능한 경로가 여러개라면 알파벳순 우선
         * 3. 항상 ICN에서 출발
         */ 
        
        
        Arrays.sort(tickets, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        
        this.tickets = tickets;
        
        visited = new int[tickets.length];
        result = new String[tickets.length+1];
        
        for(int i = 0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = 1;
                result[0] = tickets[i][0];
                if(dfs(tickets[i][1], 2) == 1)
                    break;
                visited[i] = 0;
            }
        }
        
        return result;
    }
}