import java.util.*;

class Solution {
    public List<String> directions = Arrays.asList("U", "D", "R", "L");
    public int[] moveX = {0, 0, 1, -1};     //up, down, right, left
    public int[] moveY = {-1, 1, 0, 0};
    
    public int solution(String dirs) {
        //가로 10, 세로 11
        //행 11, 열 11
        //map 만들고 수 ++, 1인 곳만 더해서 answer
        int[][] roadRows = new int[10][11];
        int[][] roadCols = new int[11][10];
        
        int result = 0;
        int[] start = {5, 5};
        
        Queue<String> q = new LinkedList<>(Arrays.asList(dirs.split(""))); 
        
        while(!q.isEmpty()){
            int idx = directions.indexOf(q.poll());
            int x = start[0] + moveX[idx];
            int y = start[1] + moveY[idx];
            
            if(x>=0 && x<=10 && y>=0 && y<=10){
                if(idx == 0 && roadCols[x][y] == 0){ //up일 때
                    result++;
                    roadCols[x][y] = 1;
                }else if(idx == 1 && roadCols[x][start[1]] == 0){ //down일 때
                    result++;
                    roadCols[x][start[1]] = 1;
                }else if(idx == 2 && roadRows[start[0]][y]==0){ //right일 때
                    result++;
                    roadRows[start[0]][y] = 1;
                }else if(idx == 3 && roadRows[x][y] == 0){              //left일 때
                    result++;
                    roadRows[x][y] = 1;
                }
                
                start = new int[]{x, y};
            }
        }
        
        return result;
        
    }
}