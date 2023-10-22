import java.util.*;

class Solution {
    public int[][] columns;     //기둥
    public int[][] rows;    //보
    
    public boolean checkColumn(int x, int y){
        if(y==0)    //바닥일 때
            return true;
        
        if(x>0 && rows[x-1][y] == 1)    //보의 한 쪽 끝 위일 때
            return true;
        
        if(x< rows.length && rows[x][y] == 1)   //보의 한 쪽 끝 위일 때
            return true;
        
        if(y>0 && columns[x][y-1] == 1) //다른 기둥 위일 때
            return true;
        
        return false;
    }
    
    public boolean checkRow(int x, int y) {
        if(y>0 && columns[x][y-1] == 1) //한 쪽 끝이 기둥 위일 때
            return true;
        
        if(y > 0 && columns[x+1][y-1] == 1) //한 쪽 끝이 기둥 위일 때
            return true;
        
        if(x>0 && x+1<rows.length && rows[x-1][y] ==1 && rows[x+1][y] == 1) //양쪽 끝이 다른 보일 때
            return true;
        
        return false;
    }
    
    public boolean canDeleteColumn(int x, int y){
        if(x>0 && rows[x-1][y+1] ==1 && !checkRow(x-1, y+1))
            return false;
        
        if(rows[x][y+1] ==1 && !checkRow(x, y+1))
            return false; 
        
        if(y+1<columns[0].length && columns[x][y+1] == 1 && !checkColumn(x, y+1))
            return false;
        
        return true;
    }
    
    public boolean canDeleteRow(int x, int y){
        if(x>0 && rows[x-1][y] ==1 && !checkRow(x-1, y))
            return false;
        
        if(x+1<rows.length && rows[x+1][y] == 1 && !checkRow(x+1, y))
            return false;
        
        if(y < columns[0].length && columns[x][y] == 1 && !checkColumn(x, y))
            return false;
        
        if(y < columns[0].length && columns[x+1][y] ==1 && !checkColumn(x+1, y))
            return false;
        
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        /* 교차점 x, y에 대해
        * 기둥 설치 -> 바닥인지(y = 0) || 보의 한 쪽 끝인지(x-1, y이 1 | x, y이 1) || 다른 기둥 위(x, y-1 이 1)
        * 보 설치 -> 한 쪽 끝이 기둥 위(x, y-1이 1 | x+1, y-1이 1) || 양쪽 끝이 다른 보(x-1, y가 1 && x+1, y가 1)
        * 기둥 삭제 -> x-1, y+1의 보 | x, y+1의 보 | x, y+1의 기둥 확인
        * 보 삭제 -> x-1, y의 보|| x+1, y의 보 || x, y의 기둥 확인 || x+1, y의 기둥 확인
        */
        
        columns = new int[n+1][n];
        rows = new int[n][n+1];
        
        for(int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            
            if(frame[3] == 0){  //구조물 삭제
                if(frame[2] == 0) { //기둥 삭제
                    if(x>=0 && x<columns.length && y>=0 && y<columns[0].length) {
                        
                        if(columns[x][y] == 1) {    //기둥 존재 확인
                            columns[x][y] = 0;  //일단 기둥 삭제
                            
                            if(!canDeleteColumn(x, y))
                                columns[x][y] = 1;  //삭제 불가능하면 다시 추가
                        }
                    }
                }else if(frame[2] == 1) {   //보 삭제
                    if(x>=0 && x<rows.length && y>=0 && y<rows[0].length){
                        
                        if(rows[x][y] == 1) { //보 존재 확인
                            rows[x][y] = 0; //일단 보 삭제
                            
                            if(!canDeleteRow(x, y))
                                rows[x][y] = 1; //삭제 불가능하면 다시 추가
                        }
                    }
                }
                
            }else if(frame[3] == 1){    //구조물 추가
                if(frame[2] == 0) { //기둥 설치
                    if(x>=0 && x<columns.length && y>=0 && y<columns[0].length) {
                        if(columns[x][y] == 0 && checkColumn(x, y))
                            columns[x][y] = 1;
                    }
                    
                }else if(frame[2] == 1){    //보 설치
                    if(x>=0 && x<rows.length && y>=0 && y<rows[0].length){
                        if(rows[x][y] == 0 && checkRow(x, y))
                            rows[x][y] = 1;
                    }
                }
            }
        }
        
        
        List<int[]> buildings = new ArrayList<>();
        
        //기둥 담기
        for(int i = 0; i<columns.length; i++){
            for(int j = 0; j<columns[0].length; j++){
                if(columns[i][j] == 1){
                    
                    int[] temp = new int[]{i, j, 0};
                    buildings.add(temp);
                }
            }
        }
        
        //보 담기
        for(int i = 0; i<rows.length; i++){
            for(int j = 0; j<rows[0].length; j++){
                if(rows[i][j] == 1){
                    int[] temp = new int[]{i, j, 1};
                    buildings.add(temp);
                }
            }
        }
        
        int[][] result = new int[buildings.size()][3];
        
        for(int i = 0; i<result.length; i++)
            result[i] = buildings.get(i);
        
        Arrays.sort(result, (o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1]){
                    return o1[2] - o2[2];
                }
                return o1[1]-o2[1];
            }
            
            return o1[0]-o2[0];
        });
        
        return result;
    }
}