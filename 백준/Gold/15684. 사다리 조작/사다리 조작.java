import java.util.*;
import java.io.*;

public class Main{
    public static int n, m, h;
    public static int[][] map;
    
    public static void dfs(int idx, int depth){
        if(idx == depth){
            if(check()){
                System.out.println(depth);
                System.exit(0);
            }
            return;
        }
        
        for(int i = 0; i<h; i++){
            for(int j = 1; j<n; j++){
                if(map[i+1][j]==1 || map[i+1][j-1] == 1 || map[i+1][j+1] == 1){
                    continue;
                }
                map[i+1][j] = 1;
                dfs(idx+1, depth);
                map[i+1][j] = 0;
            }
        }
    }
    
    public static boolean check(){ 
        for(int i = 1; i<=n; i++){
            int x = 1;
            int y= i;
            
            while(x<=h){
                if(map[x][y]==1){
                    y++;
                }else if(map[x][y-1]==1){
                    y--;
                }
                x++;
            }
            
            if(y != i){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h+1][n+1];
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            
            map[a][b] = 1;     //b와 b+1에 가로선
        }
        
        //사다리 생성  -> 최대 3개
        for(int i = 0; i<4; i++){
            dfs(0, i);
        }
        System.out.println(-1);    //초과할 경우
    }
}