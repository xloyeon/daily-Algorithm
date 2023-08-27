import java.util.*;

class Solution {
    
    public static int bfs(List<List<Integer>> graph, int n){
        int[] visited = new int[n+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        
        visited[1] = 1;
        int count = 0;
        int max = 0;    //최대 길이 저장
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int v = temp[0];
            int d = temp[1];
            
            if(max == d) count++;
            else if(max < d){
                max = d;
                count = 1;
            }
            
            for(int i = 0; i<graph.get(v).size(); i++){
                int node = graph.get(v).get(i);
                
                if(visited[node] ==0){
                    q.add(new int[]{node, d+1});
                    visited[node] = 1;
                }
            }
        }
        return count;
        
    }
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        return bfs(graph, n);
    }
}