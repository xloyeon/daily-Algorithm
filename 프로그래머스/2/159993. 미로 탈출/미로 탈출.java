import java.util.*;

class Solution {
    public int[] sPos;  //시작점
    public int[] ePos;   //끝점
    public int[] lPos;  //레버위치
    public int[][] mirror;
    public int[] dirX = {0, 0, -1, 1};
    public int[] dirY = {-1, 1, 0, 0};
    
    public int bfs(int[] start, int[] end){
        int[][] visited = new int[mirror.length][mirror[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
      
        while(!q.isEmpty()){
            int[] next = q.poll();
            
            if(next[0] == end[0] && next[1] == end[1]){
                return visited[next[0]][next[1]];
            }
            
            for(int i = 0; i<4; i++){
                int nextX = next[1] + dirX[i];
                int nextY = next[0] + dirY[i];
                
                if(nextX<0 || nextY<0 || nextX>=mirror[0].length || nextY>=mirror.length)
                    continue;
                
                if(mirror[nextY][nextX] == 1)
                    continue;
                
                if(visited[nextY][nextX] !=0)
                    continue;
                
                visited[nextY][nextX] = visited[next[0]][next[1]]+1;
                q.add(new int[]{nextY, nextX});
            }
        }
        
        return -1;       
    }
    
    public int solution(String[] maps) {
        // 무조건 레버먼저 당기고 문으로 이동 가능하므로
        // 레버위치까지 가는 시간 + 레버위치에서 문 위치까지 가는 시간
        this.mirror = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i<maps.length; i++){
            String[] sArr = maps[i].split("");
            
            for(int j = 0; j<sArr.length; j++){
                if(sArr[j].equals("S"))
                    sPos = new int[]{i, j};
                else if(sArr[j].equals("E"))
                    ePos = new int[]{i, j};
                else if(sArr[j].equals("L"))
                    lPos = new int[]{i, j};
                else if(sArr[j].equals("X"))
                    mirror[i][j] = 1;
            }
        }
        
        int cnt1 = bfs(sPos, lPos);
        if(cnt1 == -1) 
            return -1;
        int cnt2 = bfs(lPos, ePos);
        if(cnt2 == -1)
            return -1;
        
        return cnt1+cnt2;
        
    }
}