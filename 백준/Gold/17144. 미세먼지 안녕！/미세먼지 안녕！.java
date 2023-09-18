import java.util.*;
import java.io.*;

public class Main {
    public static int R, C, T;
    public static int[][] map;
    public static int up;
    public static int down;
    public static int[] dX = {1, -1, 0, 0};
    public static int[] dY = {0, 0, 1, -1};
    
    public static void spreadDust(){
        int[][] temp = new int[R][C];
        
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(map[i][j] ==-1){
                    temp[i][j] = map[i][j];
                    continue;
                }
                
                temp[i][j] += map[i][j];
                
                for(int k = 0; k<4; k++){
                    int x = j + dX[k];
                    int y = i + dY[k];
                    
                    if(x>=0 && x<C && y>=0 && y<R){
                        if(map[y][x]>=0){
                            temp[y][x] += (map[i][j]/5);
                            temp[i][j] -= (map[i][j]/5);
                        }
                    }
                }
            }
        }    
        
        map = temp;
    }
    
    public static void cleanAir(){
        //반시계방향
        for(int i = up-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }
        
        for(int i = 0; i<C-1; i++){
            map[0][i] = map[0][i+1];
        }
        
        for(int i =0; i<up; i++){
            map[i][C-1] = map[i+1][C-1];
        }
        
        for(int i = C-1; i>1; i--){
            map[up][i] = map[up][i-1];
        }
        
        map[up][1] = 0;    //먼지 0
        
        for(int i = down+1; i<R-1; i++){
            map[i][0] = map[i+1][0];
        }
        
        for(int i = 0; i<C-1; i++){
            map[R-1][i] = map[R-1][i+1];
        }
        
        for(int i = R-1; i>down; i--){
            map[i][C-1] = map[i-1][C-1];
        }
        
        for(int i = C-1; i>1; i--){
            map[down][i] = map[down][i-1];
        }
        
        map[down][1] = 0;    //먼지 0
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        
        boolean flag = false;
        
        for(int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            
            if(map[i][0] == -1 && !flag){    //공기청정기 위치면
                up = i;
                down = i+1;
                flag = true;
            }
        }
        
        for(int i = 0; i<T; i++){
            spreadDust();
            cleanAir();
        }
        
        int result = 0;
        
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                result += map[i][j];
            }
        }
        
        System.out.println(result+2);
    }
}