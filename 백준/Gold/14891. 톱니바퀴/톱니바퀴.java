import java.io.*;
import java.util.*;

public class Main{
    public static int[] visited;    //방문 처리 위함
    
    public static void rotate(int[][] wheel, int idx, int dir) {
        visited[idx-1] = 1;    //방문처리
        
        //왼쪽 바퀴와 현재 바퀴의 극이 다르면
        if(idx>1 && visited[idx-2] !=1 && wheel[idx-1][6] != wheel[idx-2][2]){
            rotate(wheel, idx-1, dir*-1);
        }
        //오른쪽 바퀴와 현재 바퀴의 극이 다르면
        if(idx<4 && visited[idx] !=1 && wheel[idx-1][2] != wheel[idx][6]){
            rotate(wheel, idx+1, dir*-1);
        }
        
        if(dir == 1){
            int temp = wheel[idx-1][7];

            for (int i = 7; i > 0; i--) {
                wheel[idx-1][i] = wheel[idx-1][i-1];
            }
            wheel[idx-1][0] = temp;
      
        }else if(dir== -1){
            int temp = wheel[idx-1][0];

            for (int i = 0; i < 7; i++) {
                wheel[idx-1][i] = wheel[idx-1][i+1];
            }

            wheel[idx-1][7] = temp;
            
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] wheel = new int[4][8];
        
        for(int i = 0; i<4; i++){
            char[] c = br.readLine().toCharArray();
            
            for(int j = 0; j<8; j++){
                wheel[i][j] = Character.getNumericValue(c[j]);
            }
        }
        
        int k = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            
            //차례대로 바퀴 돌림 -> 이미 돌린건 돌리지 x
            visited = new int[4];
            rotate(wheel, idx, dir);
        }
        
        int result = 0;
        
        for(int i = 0, j = 1; i<4; i++, j*=2){
            if(wheel[i][0] == 1){
                result += j;
            }
        }
        System.out.println(result);
        
    }
}