import java.util.*;

class Solution {
    public int[] dirX = {0, 0, -1, 1};    //상, 하, 좌, 우
    public int[] dirY = {-1, 1, 0, 0}; 
    
    public int solution(int[][] maps) {
        // 상대팀 진영에 도착할 수 없는 경우를 먼저 알 수 있을까?
        // (0, 0) 이 시작점, (n-1, m-1)이 끝점
        
        int n = maps[0].length;
        int m = maps.length;
        
        int[][] visited = new int[m][n];
        
        Queue<int[]> q = new LinkedList<>();
        
        // 시작점 넣기
        q.add(new int[]{0,0});  
        visited[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] path = q.poll();
           
            if(path[0] == m-1 && path[1] == n-1)
                return visited[m-1][n-1];
            
            int nextX = 0;
            int nextY = 0;
            
            for(int i = 0; i<4; i++){
                nextX = path[1] + dirX[i];
                nextY = path[0] + dirY[i];
                
                // 다음 위치가 게임 맵 밖일 때
                if(nextX<0 || nextY<0 || nextX>=n || nextY>=m)
                    continue;
                
                // 다음 위치가 벽이 있는 자리일 때
                if(maps[nextY][nextX] == 0) 
                    continue;
                
                // 이미 간 적 있는 경우
                if(visited[nextY][nextX] !=0)
                    continue;
                
                visited[nextY][nextX] = visited[path[0]][path[1]]+1;
                q.add(new int[]{nextY, nextX});
            }
        }
        
        return -1;
    }
}