import java.util.*;

class Solution {
    public int[] infos;
    public ArrayList<Integer>[] nodes;
    public int max = 0;
    
    public void dfs(int idx, int sheep, int wolf, List<Integer> path) {
        if(infos[idx] == 0) sheep++;
        else wolf++;
        
        if(wolf>=sheep) return;
        max = Math.max(sheep, max); 
        
        List<Integer> tempList = new ArrayList<>(path);
        tempList.remove(Integer.valueOf(idx));  //현재 위치는 삭제
        
        if(nodes[idx] != null){
            tempList.addAll(nodes[idx]);
        }
        
        for(int p : tempList){
            dfs(p, sheep, wolf, tempList);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        //양의 수 > 늑대 수 이어야 함
        infos = info;
        nodes = new ArrayList[info.length];
        
        for(int[] edge : edges) {
            if(nodes[edge[0]] == null)
                nodes[edge[0]] = new ArrayList<>(); //초기화
            
            nodes[edge[0]].add(edge[1]);
        }
        
        List<Integer> first = new ArrayList<>();
        first.add(0);
        
        dfs(0, 0, 0, first);
        
        return max;
    }
}