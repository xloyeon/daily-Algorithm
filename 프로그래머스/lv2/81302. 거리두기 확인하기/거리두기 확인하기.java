import java.util.*;

class Solution {
    public int[] moveX = {0, 0, 1, 1, 2, 1, 0, 0};
    public int[] moveY = {-2, -1, -1, 0, 0, 1, 1, 2};
    public String[][] rooms;
    
    public int checkDistance(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(rooms[i][j].equals("P") && !keepDistance(i, j)){
                    return 0;
                }
            }
        }
        return 1;
    }
    
    public boolean keepDistance(int i, int j){
        for(int k = 0; k<moveX.length; k++){
            int x = i + moveX[k];
            int y = j + moveY[k];
            
            if(x>=0 && x<5 && y>=0 && y<5 && rooms[x][y].equals("P")){
                if(i == x && Math.abs(y-j)==1){
                    return false;
                }else if(j==y && Math.abs(x-i)==1){
                    return false;
                }else if(i==x){
                    if(!rooms[x][(y+j)/2].equals("X"))
                        return false;
                }else if(j==y) {
                    if(!rooms[(x+i)/2][y].equals("X"))
                        return false;
                }else if(!rooms[x][j].equals("X") || !rooms[i][y].equals("X")){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int idx = 0;
        int[] result = new int[places.length];

        for(String[] place : places) {
            rooms = new String[5][5];
            
            for(int i = 0; i<5; i++){
                for(int j = 0; j<5; j++){
                    rooms[i][j] = String.valueOf(place[i].charAt(j));
                }
            }
            
            result[idx++] = checkDistance();
        }        
        return result;
    }
    
}