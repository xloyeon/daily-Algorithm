import java.io.*;
import java.util.*;

public class Main {
    
    public static int N, sharkX, sharkY;
    public static int eat, size;
    public static int[][] map;
    public static int[] dX = {1, -1, 0, 0};
    public static int[] dY = {0, 0, 1, -1};
    
    public static int eatFish(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        q.add(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;
        
        int minX = Integer.MAX_VALUE;    //최소x
        int minY = Integer.MAX_VALUE;    //최소y
        int minD = Integer.MAX_VALUE;    //거리
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(temp[2] >= minD)
                continue;
            
            for(int i = 0; i<4; i++){
                int movedX = temp[0] + dX[i];
                int movedY = temp[1] + dY[i];
                
                if(movedX>=0 && movedX<N && movedY>=0 && movedY<N){
                    if(visited[movedX][movedY]){
                        continue;
                    }
                    
                    if(map[movedX][movedY] > size)    //상어 크기를 넘으면
                        continue;
                    
                    //먹을 수 있는 물고기면
                    
                    if(map[movedX][movedY] != 0 && map[movedX][movedY]<size) {
                        if(movedX<minX){
                            minX = movedX;
                            minY = movedY;
                            minD = temp[2] +1;
                        }else if(movedX == minX && movedY<minY){
                            minY = movedY;
                            minD = temp[2] + 1;
                        }
                    }
                    
                    q.add(new int[]{movedX, movedY, temp[2] +1});
                    visited[movedX][movedY] = true;
                }
            }
        }
        
        if(minD == Integer.MAX_VALUE) return -1;
        
        sharkX = minX;
        sharkY = minY;
        eat++;
        
        if(eat == size){
            eat = 0;
            size++;
        }
        
        map[sharkX][sharkY] = 0;
        return minD;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 9){
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }
        
        eat = 0;    //먹은 고기 수
        size = 2;
        int totalTime = 0;
        
        while(true){
            int time = eatFish();
            
            if(time == -1)
                break;
            else 
                totalTime += time;
        }
        
        System.out.println(totalTime);
    }
}