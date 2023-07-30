import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, x, y, k;
    public static int[][] map;
    public static int[] moveX = {0, 0, -1, 1};
    public static int[] moveY = {1, -1, 0, 0};
    public static int[] dice = {0, 0, 0, 0, 0, 0};
    
    public static void moveRight() {
        int temp = dice[0];
        dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;
    }
    
    public static void moveLeft() {
        int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;
    }
    
    public static void moveUp() {
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;
		
	}
	
	public static void moveDown() {
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
	}
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       x = Integer.parseInt(st.nextToken());
       y = Integer.parseInt(st.nextToken());
       k = Integer.parseInt(st.nextToken());
       
       map = new int[n][m];
       
       for(int i = 0; i<n; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j<m; j++){
               map[i][j]= Integer.parseInt(st.nextToken());  
           }
       }
       
       st = new StringTokenizer(br.readLine());
       
       for(int i = 0; i<k; i++) {
            int idx = Integer.parseInt(st.nextToken()) -1;
            x += moveX[idx];
            y += moveY[idx];
            
            if(x <0 || x>=n || y<0 || y>=m) {
                x -= moveX[idx];
                y -= moveY[idx];
                continue;
            }
            
            if(idx == 0){
                moveRight();
            }else if(idx == 1){
                moveLeft();
            }else if(idx == 2){
                moveUp();
            }else if(idx == 3){
                moveDown();
            }
            
            if(map[x][y] == 0){
                map[x][y] = dice[1];
            }else{
                dice[1] = map[x][y];
                map[x][y] = 0;
            }
            
            System.out.println(dice[0]);
       }
    }
}