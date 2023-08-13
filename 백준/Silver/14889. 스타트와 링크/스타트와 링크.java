import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static int[] visited;
    public static int min = Integer.MAX_VALUE;
    
    public static void dfs(int idx, int d){
        if(d == n/2){
            int start = 0;
            int link = 0;
            
            for(int i = 0; i<n-1; i++){
                for(int j = i+1; j<n; j++){
                    if(visited[i] == 1 && visited[j] == 1){
                        start += map[i][j];
                        start += map[j][i];
                    }else if(visited[i] !=1 && visited[j] !=1){
                        link += map[i][j];
                        link += map[j][i];
                    }
                }
            }
            
            int diff = Math.abs(start - link);    //두 팀 점수 차
            
            if(diff == 0){
                System.out.println(diff);
                System.exit(0);
            }
            
            min = Math.min(diff, min);
            return;
        }
        
        for(int i = idx; i<n; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(i+1, d+1);
                visited[i] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new int[n];
        
        for (int i = 0; i < n; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             for (int j = 0; j < n; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
        }
        
        dfs(0, 0);
        System.out.println(min);
    }
}