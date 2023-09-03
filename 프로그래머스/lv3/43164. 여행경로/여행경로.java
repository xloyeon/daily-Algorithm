import java.util.*;

class Solution {
    public List<String[]> resultList = new ArrayList<>();
    public String[] airport;
    public boolean[] visited;
    
    public void dfs(int depth, int idx, String[][] tickets){
        if(depth == idx){
            resultList.add(airport.clone());
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i] && airport[idx].equals(tickets[i][0])){
                airport[idx+1] = tickets[i][1];
                visited[i] = true;
                dfs(depth, idx+1, tickets);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        for(int i = 0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN"))  { //ICN에서 무조건 출발
                airport = new String[tickets.length + 1];
                visited = new boolean[tickets.length];
                airport[0] = tickets[i][0];
                airport[1] = tickets[i][1];
                visited[i] = true;
                dfs(tickets.length, 1, tickets);
            }
        }
        
        Collections.sort(resultList, (o1, o2) -> {
            for(int i = 0; i<o1.length; i++){
                if(!o1[i].equals(o2[i]))
                    return o1[i].compareTo(o2[i]);
            }
            return o1[o1.length-1].compareTo(o2[o2.length-1]);
        });
        
        return resultList.get(0);
    }
}