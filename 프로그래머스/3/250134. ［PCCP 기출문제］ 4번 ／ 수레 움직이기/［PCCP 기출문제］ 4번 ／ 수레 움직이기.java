import java.util.*;

class Cart {
    int rX, rY, bX, bY;
    int visitedR, visitedB;
    int turn;
        
    public Cart(int rX, int rY, int bX, int bY, int visitedR, int visitedB, int turn) {
        this.rX = rX;
        this.rY = rY;
        this.bX = bX;
        this.bY = bY;
        this.visitedR = visitedR;
        this.visitedB = visitedB;
        this.turn = turn;
    }
}

class Solution {
    int n, m;
    int[] dirX = {0, 0, -1, 1};
    int[] dirY = {-1, 1, 0, 0};
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        
        int rStartX = 0, rStartY = 0, rEndX = 0, rEndY = 0;
        int bStartX = 0, bStartY = 0, bEndX = 0, bEndY = 0;
        
        // red, blue 시작/종료 좌표 찾기
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(maze[i][j] == 1) { rStartX=j; rStartY=i; }
                if(maze[i][j] == 2) { bStartX=j; bStartY=i; }
                if(maze[i][j] == 3) { rEndX=j; rEndY=i; }
                if(maze[i][j] == 4) { bEndX=j; bEndY=i; }
            }
        }
        
        Queue<Cart> q = new LinkedList<>();
        
        //시작점 비트마스크로 저장
        int startRMask = 1 << (rStartY * m + rStartX);
        int startBMask = 1 << (bStartY * m + bStartX);
        
        //시작점 넣기
        q.add(new Cart(rStartX, rStartY, bStartX, bStartY, startRMask, startBMask, 0));
        
        // red + blue 합친 상태 체크할 set 세팅
        Set<String> visited = new HashSet<>();
        visited.add(rStartX+","+rStartY+","+bStartX+","+bStartY+","+startRMask+","+startBMask);
        
        while(!q.isEmpty()) {
            Cart cur = q.poll();
            
            boolean arrivedR = (cur.rX == rEndX && cur.rY == rEndY);
            boolean arrivedB = (cur.bX == bEndX && cur.bY == bEndY);
            if(arrivedR && arrivedB) return cur.turn;
            
            // 빨간 수레 이동
            for(int i=0;i<4;i++){
                int nextRX = cur.rX;
                int nextRY = cur.rY;
                int nextRMask = cur.visitedR;
                if(!arrivedR) {
                    nextRX = cur.rX + dirX[i];
                    nextRY = cur.rY + dirY[i];
                    if(nextRX<0||nextRX>=m||nextRY<0||nextRY>=n) continue;
                    if(maze[nextRY][nextRX]==5) continue;
                    int bit = 1 << (nextRY*m+nextRX);
                    if((cur.visitedR & bit)!=0) continue; // 이미 방문
                    nextRMask |= bit;
                }
                
                // 파란 수레 이동
                for(int j=0;j<4;j++){
                    int nextBX = cur.bX;
                    int nextBY = cur.bY;
                    int nextBMask = cur.visitedB;
                    if(!arrivedB){
                        nextBX = cur.bX + dirX[j];
                        nextBY = cur.bY + dirY[j];
                        if(nextBX<0||nextBX>=m||nextBY<0||nextBY>=n) continue;
                        if(maze[nextBY][nextBX]==5) continue;
                        int bitB = 1 << (nextBY*m+nextBX);
                        if((cur.visitedB & bitB)!=0) continue;
                        nextBMask |= bitB;
                    }
                    
                    // 서로 같은 칸으로 이동하는 경우 불가
                    if(nextRX==nextBX && nextRY==nextBY) continue;
                    // 서로 자리 바꾸는 이동 불가
                    if(nextRX==cur.bX && nextRY==cur.bY && nextBX==cur.rX && nextBY==cur.rY) continue;
                    
                    String key = nextRX+","+nextRY+","+nextBX+","+nextBY+","+nextRMask+","+nextBMask;
                    if(visited.contains(key)) continue;
                    visited.add(key);
                    q.add(new Cart(nextRX,nextRY,nextBX,nextBY,nextRMask,nextBMask,cur.turn+1));
                }
            }
        }
        
        return 0; // 도달 불가
    }
}
