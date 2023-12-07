import java.util.*;

class Robot {
    int x;
    int y;
    int dir;    //0이면 가로, 1이면 세로
    int time;
    
    public Robot(int x, int y, int dir, int time){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.time = time;
    }
}

class Solution {
    public int endX, endY;
    public int[][] map;
    public int[] dX = {1, -1, 0, 0};
    public int[] dY = {0, 0, 1, -1};
    public int[][] rX = {{-1, 0, -1, 0}, {0, 0, 1, 1}};
    public int[][] rY = {{0, 0, 1, 1}, {-1, 0, -1, 0}};
    public int[][] checkX = {{-1, 1, -1, 1}, {1, 1, 0, 0}};
    public int[][] checkY = {{1, 1, 0, 0}, {-1, 1, -1, 1}};
    public boolean[][][] visited;
    
    public boolean checkArrival(Robot robot){
        if(robot.dir == 0 && robot.x == endX && robot.y+1 == endY)
            return true;
        
        if(robot.dir == 1 && robot.x+1 == endX && robot.y == endY)
            return true;
        
        return false;
    }
    
    public boolean canMove(int dir, int x, int y){
        //범위 벗어난 경우
        if(y < 0 || y >=endY+1)
            return false;
        
        if(x <0 || x >= endX+1)
            return false;
        
        if(visited[dir][x][y])  //이미 방문한 경우
            return false;
        
        if(map[x][y] == 1)  //벽인 경우
            return false;
        
        if(dir == 0 && (y>=endY || map[x][y+1] == 1))
            return false;
        
        if(dir ==1 && (x>=endX || map[x+1][y] == 1))
            return false;
        
        return true;
    }
    
    
    public int bfs() {
        Queue<Robot> q = new LinkedList<>();
        visited = new boolean[2][map.length][map[0].length];
        
        q.add(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;    //처음 시작은 가로 방향
        
        while(!q.isEmpty()){
            Robot robot = q.poll();
            
            //로봇이 목적지에 도달했다면
            if(checkArrival(robot)) {
                return robot.time;
            }
            
            //회전 안 하고 이동할 수 있으면 이동하기
            for(int i = 0; i<4; i++){
                int movedX = robot.x + dX[i];
                int movedY = robot.y + dY[i];
                
                if(!canMove(robot.dir, movedX, movedY))
                    continue;
                
                visited[robot.dir][movedX][movedY] = true;
                q.add(new Robot(movedX, movedY, robot.dir, robot.time+1));
            }
            
            //회전할 수 있으면 회전만 하고 다시 넣기
            int nextDir = robot.dir == 0? 1:0;
        
            for(int i = 0; i<4; i++){
                int movedX = robot.x + rX[robot.dir][i];
                int movedY = robot.y + rY[robot.dir][i];
                
                int tempX = robot.x + checkX[robot.dir][i];
                int tempY = robot.y + checkY[robot.dir][i];
                
                if(canMove(nextDir, movedX, movedY) && map[tempX][tempY] == 0){
                        visited[nextDir][movedX][movedY] = true;
                        q.add(new Robot(movedX, movedY, nextDir, robot.time+1));
                }
            }
            
        }
        return 0;
    }
    
    public int solution(int[][] board) {
        //0,0에서 시작한다고 생각
        //가로 방향일 때 회전 축이 움직이는 로봇 칸 기준으로
        //아래가 없으면 회전 축 아래 칸으로 이동 가능
        // 위가 없으면 회전 축 위 칸으로 이동 가능
        
        //세로 방향일 때 회전 축이 움직이는 로봇 칸 기준으로
        //오른쪽 없으면 회전 축 오른 칸으로 이동 가능
        //왼쪽 없으면 회전 축 왼 칸으로 이동 가능
        endX = board.length-1;
        endY = board.length-1;
        map = board;
       
        return bfs();
    }
}