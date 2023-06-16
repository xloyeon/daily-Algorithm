import java.util.*;

class Solution {
    public int[] start;
    public int[] moveX = {1, 0, 0, -1};
    public int[] moveY = {0, 1, -1, 0};
    public String[][] map;
    
    public int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[map.length][map[0].length];
        q.add(start);
        visited[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[1];
            int y = cur[0];
            
            if(map[y][x].equals("G"))
                return visited[y][x]-1;
            
            for(int i = 0; i<4; i++){
                int movedX = x;
                int movedY = y;
                
                while(true){
                    movedX += moveX[i];
                    movedY += moveY[i];
                    
                    if(movedX>=0 && movedX<map[0].length && movedY>=0 && movedY<map.length){
                        if(map[movedY][movedX].equals("D")){
                            movedX -= moveX[i];
                            movedY -= moveY[i];
                            break;
                        }
                    }else{
                        movedX -= moveX[i];
                        movedY -= moveY[i];
                        break;
                    }
                }
                
                if(movedX == x && movedY == y)
                    continue;
                
                if(visited[movedY][movedX] == 0){
                    q.add(new int[]{movedY, movedX});
                    visited[movedY][movedX] = visited[y][x] + 1;
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] board) {
        map = new String[board.length][board[0].length()];
        
        for(int i = 0; i<board.length; i++){
            map[i] = board[i].split("");
            
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j].equals("R"))
                    start = new int[]{i, j};
            }
        }
        
        return bfs();
    }
}