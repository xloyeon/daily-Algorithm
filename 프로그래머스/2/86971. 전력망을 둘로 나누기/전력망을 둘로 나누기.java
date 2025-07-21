import java.util.*;

class Solution {
    public int n = 0;
    public int[][] maps;
    public int result = Integer.MAX_VALUE;
    
    public void makeMaps(int[][] wires){
        
        for(int i = 0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];     
            maps[v1][v2] = 1;
            maps[v2][v1] = 1;
        }
    }
    
    
    public int bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        
        q.add(v);
        visited[v] = 1;
        int count = 1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int i = 1; i<=n; i++){
                if(maps[node][i] == 1 && visited[i] == 0){
                    q.add(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }
        
        return count;     
    }
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.maps = new int[n+1][n+1];  

        // 전선 연결정보 2차원 map으로 만들기
        makeMaps(wires);
        
        // 전선 연결정보 하나씩 탐색하며 끊고 확인해보기
        for(int i = 0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 전선 끊기
            maps[v1][v2] = 0;
            maps[v2][v1] = 0;
            
            int cnt = Math.abs(bfs(v1)-bfs(v2));
            result = Math.min(result, cnt);
            
            // 돌려놓기
            maps[v1][v2] = 1;
            maps[v2][v1] = 1;
        }    
        
        return result;
    }
}