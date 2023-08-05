import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int max = Integer.MIN_VALUE;
    public static int[][] map;
    public static int[] moveX = {0, 0, -1, 1};
    public static int[] moveY = {1, -1, 0, 0};
    
    public static void dfs(int idx) {
        if(idx == 3){
            bfs();     //바이러스 퍼뜨리기
            return;
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(idx+1);    //i, j에 벽 세우기
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void bfs() {
        int[][] newMap = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i= 0; i<n; i++) {
            newMap[i] = map[i].clone();
            
            for(int j = 0; j<m; j++) {
                if(newMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[1];
            int y = temp[0];
            
            for(int i = 0; i<4; i++){
                int movedX = x+ moveX[i];
                int movedY = y+moveY[i];
                
                if(movedX >=0 && movedX <m && movedY >=0 && movedY <n && newMap[movedY][movedX] == 0) {
                    newMap[movedY][movedX] = 2;    //바이러스
                    q.add(new int[]{movedY, movedX});
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(newMap[i][j] == 0){
                    count++;
                }
            }
        }
        max = Math.max(max, count);
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);    //벽 세우기
        System.out.println(max);
        
    }
}