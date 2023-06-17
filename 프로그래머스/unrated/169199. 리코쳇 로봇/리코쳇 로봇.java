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
            
            //도착지점 도달하면 이동 수 리턴
            if(map[y][x].equals("G"))
                return visited[y][x]-1;
            
            for(int i = 0; i<4; i++){
                int movedX = x;
                int movedY = y;
                
                //장애물이나 끝에 부딪힐 때까지 미끄러져 이동
                while(true){
                    movedX += moveX[i];
                    movedY += moveY[i];
                    
                    //범위 안에 있으면
                    if(movedX>=0 && movedX<map[0].length && movedY>=0 && movedY<map.length){
                        //장애물인지 확인하고 이전지점을 마지막으로
                        if(map[movedY][movedX].equals("D")){
                            movedX -= moveX[i];
                            movedY -= moveY[i];
                            break;
                        }
                    }else{
                        //범위 밖이면 이전 지점을 마지막으로
                        movedX -= moveX[i];
                        movedY -= moveY[i];
                        break;
                    }
                }
                
                //이전 지점이 기존 좌표랑 같으면 해당 방향으로 이동 불가능
                if(movedX == x && movedY == y)
                    continue;
                
                //미끄러져 이동한 위치가 이전에 방문한 적 없을 때에만 -> 최소
                if(visited[movedY][movedX] == 0){
                    q.add(new int[]{movedY, movedX});
                    visited[movedY][movedX] = visited[y][x] + 1;
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] board) {
        //보드게임판 2차원 배열로 만들기
        map = new String[board.length][board[0].length()];
        
        for(int i = 0; i<board.length; i++){
            map[i] = board[i].split("");
            
            //시작 지점 확인 저장
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j].equals("R"))
                    start = new int[]{i, j};
            }
        }
        
        return bfs();
    }
}