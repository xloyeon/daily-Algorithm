import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int max = Integer.MIN_VALUE;
    public static int[][] map;
    public static int[][] visited;
    public static int[] moveX = {0, 0, -1, 1};
    public static int[] moveY = {-1, 1, 0, 0};
    
    public static void dfs(int y, int x, int idx, int sum) {
        if(idx >=4){
            max = Math.max(max, sum);
            return;
        }
        
        for(int i = 0; i<4; i++) {
            int movedX = x + moveX[i];
            int movedY = y + moveY[i];
            
            if(movedX>=0 && movedX<m && movedY>=0 && movedY<n && visited[movedY][movedX] == 0) {
                
                if(idx == 2) {    //특수 경우 만들 수 있을 경우
                    visited[movedY][movedX] = 1;
                    dfs(y, x, idx+1, sum + map[movedY][movedX]);
                    visited[movedY][movedX] = 0;
                }
                visited[movedY][movedX] = 1;
                dfs(movedY, movedX, idx+1, sum + map[movedY][movedX]);
                visited[movedY][movedX] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new int[n][m];
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m;j++) {
                //여기를 시작점으로 해서 4칸 씩 갈 수 있는 모든 점 탐색
                visited[i][j] = 1;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = 0;
            }
        }
        
        System.out.println(max);
    }
}