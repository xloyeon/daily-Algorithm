import java.util.*;

class Solution {
    public int[] moveX = {0, 0, 1, -1};
    public int[] moveY = {-1, 1, 0, 0};
    
    public int solution(String dirs) {
        //길을 어떻게 표현할 수 있을까? toX, toY, fromX, fromY가 있고 to/from끼리 바껴도 무방
        HashSet<String> paths = new HashSet<>();
        int x = 0;
        int y = 0;
        int movedX = 0;
        int movedY = 0;
        
        for(String dir : dirs.split("")){
            int d = 0;
            
            if(dir.equals("D")){
                d = 1;
            }else if(dir.equals("R")){
                d = 2;
            }else if(dir.equals("L")){
                d = 3;
            }
            
            movedX = x + moveX[d];
            movedY = y + moveY[d];
            
            if(movedX<-5 || movedX >5 || movedY <-5 || movedY >5)
                continue;
            
            String path = "";
            if(movedX<x || (movedX>=x && movedY<y)){
                path = ""+movedX + movedY + x + y;
            }else{
                path = "" + x + y + movedX + movedY;
            }
            
            paths.add(path);
            x = movedX;
            y = movedY;
        }
        
        return paths.size();
    }
}