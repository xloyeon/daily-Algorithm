import java.util.*;

class Solution {
    public int[] moveX = {1, 0, 0, -1};
    public int[] moveY = {0, 1, -1, 0};
    
    public int solution(int[][] maps) {
        
        Queue<Box> q = new LinkedList<>();
        q.add(new Box(0, 0));
        
        while(!q.isEmpty()){
            Box box = q.poll();
            int x = box.getX();
            int y = box.getY();
            
            for(int i = 0; i<4; i++){
                int movedX = x + moveX[i];
                int movedY = y + moveY[i];
                    
                if(movedX>=0 && movedX<=maps.length-1 && movedY >=0 && movedY<=maps[0].length-1){
                    if(maps[movedX][movedY] == 1){
                        maps[movedX][movedY] = maps[x][y] + 1;
                        q.add(new Box(movedX, movedY));
                    }
                }
            }
        }
        
        if(maps[maps.length-1][maps[0].length-1] == 1) return -1;
        return maps[maps.length-1][maps[0].length-1];
        
    }
    
}

class Box {
    private int x;
    private int y;
    
    public Box(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}