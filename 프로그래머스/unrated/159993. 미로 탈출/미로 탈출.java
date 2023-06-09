import java.util.*;

class Solution {
    public String[][] map;
    public int[] start, lever, exit;
    public int[][] isVisited;
    public int[] moveX = {1, 0, 0, -1};
    public int[] moveY = {0, 1, -1, 0};
    
    public int bfs(int[] start, int[] end){
        isVisited = new int[map.length][map[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        isVisited[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()){
            int[] block = q.poll();
            int y = block[0];
            int x = block[1];
            
            if(y == end[0] && x == end[1]){
                return isVisited[y][x];
            }
            
            for(int i = 0; i<4; i++){
                int movedX = x + moveX[i];
                int movedY = y + moveY[i];
                
                if(movedX>=0 && movedX<map[0].length && movedY>=0 && movedY<map.length){
                    if(!map[movedY][movedX].equals("X") && isVisited[movedY][movedX] == 0){
                        isVisited[movedY][movedX]= isVisited[y][x] +1;
                        q.add(new int[]{movedY, movedX});
                    }
                }
            }
        }
        return 0;
    }
    
    public int solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        
        for(int i = 0; i<maps.length; i++){
            map[i] = maps[i].split("");
            
            //시작 지점
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j].equals("S")){
                    start = new int[]{i, j};
                }else if(map[i][j].equals("L")){
                    lever = new int[]{i, j};
                }else if(map[i][j].equals("E")){
                    exit = new int[]{i, j};
                }
            }
        }
        
        int first = bfs(start, lever);
        
        if(first == 0) return -1;
        
        int second = bfs(lever, exit);
        
        if(second == 0) return -1;
    
        return first+second-2;
    }
}