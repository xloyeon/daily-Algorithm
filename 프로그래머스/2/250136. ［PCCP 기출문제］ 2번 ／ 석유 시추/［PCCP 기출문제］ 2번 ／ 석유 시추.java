import java.util.*;

class Solution {
    public int n, m;
    public int[][] visited;
    public int[] oil;
    public int[] dX = {-1, 1, 0, 0};
    public int[] dY = {0, 0, -1, 1};
    
    public void bfs(int[][] land, int i, int j){
        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;
        count = 1;
        
        Set<Integer> colSet = new HashSet<>();
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            colSet.add(cur[1]);
            
            for(int k = 0; k<4; k++){
                int x = cur[0] + dX[k];
                int y = cur[1] + dY[k];
                
                if(x<0 || y<0 || x>=n || y >=m)
                    continue;
                
                if(land[x][y] == 1 && visited[x][y] == 0){
                    q.add(new int[]{x, y});
                    visited[x][y] = 1;
                    count+=1;
                }
            }
        }
        
        for(int col : colSet){
            oil[col] += count;
        }
    }
    
    public int solution(int[][] land) {
        n = land.length;    //세로
        m = land[0].length; //가로
        
        visited = new int[n][m];
        oil = new int[m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(land[i][j] == 1 && visited[i][j] == 0)
                    bfs(land, i, j);
            }
        }
        
        Arrays.sort(oil);
        return oil[m-1];
    }
}