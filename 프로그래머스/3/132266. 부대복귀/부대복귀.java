import java.util.*;

class Solution {
    public List<List<Integer>> graph;
    public int[] distance;
    
    public void calShortest(int destination){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(destination);
        distance[destination] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 0; i<graph.get(cur).size(); i++){
                int next = graph.get(cur).get(i);
                
                if(distance[next] > distance[cur] + 1){
                    distance[next] = distance[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        graph = new ArrayList<>();
        distance = new int[n+1];
        
        //graph 초기화(연결)
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            int start = road[0];
            int end = road[1];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        //distance 초기화
        Arrays.fill(distance, n);
        
        calShortest(destination);
        
        
        int[] result = new int[sources.length];
        
        for(int i = 0; i<sources.length; i++){
            result[i] = (distance[sources[i]] < n) ? distance[sources[i]] : -1;
        }
        
        return result;
    }
}