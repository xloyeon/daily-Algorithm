import java.util.*;

class Car {
    int x;
    int y;
    int dir;   
    int cost;
    
    public Car(int x, int y, int dir, int cost){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    public int[] dirX = {0, 0, -1, 1};  //상, 하, 좌, 우
    public int[] dirY = {-1, 1, 0, 0};
    
    public int solution(int[][] board) {
        int N = board.length;
        int[][] map = new int[N][N];
        int result = Integer.MAX_VALUE;
        
        Queue<Car> q = new LinkedList<>();
        
        q.add(new Car(0, 0, 1, 100));   //아래로 이동
        q.add(new Car(0, 0, 3, 100));   //오른쪽 이동
        
        while(!q.isEmpty()){
            Car c = q.poll();
            
            if(c.x == N-1 && c.y==N-1){
                result = Math.min(result, c.cost);
                continue;
            }
            
            for(int i = 0; i<4; i++){
                int movedX = c.x + dirX[i];
                int movedY = c.y + dirY[i];
                
                if(movedX<0 || movedY<0 || movedX>=N || movedY >=N)
                    continue;
                
                if(board[movedX][movedY] == 1)
                    continue;
                
                int nextCost = (c.dir == i) ? 100 : 600;  //같은 방향으로 되돌아오는 경우는 없음
                
                if(map[movedX][movedY] == 0){
                    map[movedX][movedY] = c.cost + nextCost;
                    q.add(new Car(movedX, movedY, i, c.cost+nextCost));
                }else if(c.cost + nextCost <map[movedX][movedY] + 500){
                    map[movedX][movedY] = c.cost + nextCost;
                    q.add(new Car(movedX, movedY, i, c.cost+nextCost));
                }
            }
        }
        
        return result-100;
    }
}