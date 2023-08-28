import java.util.*;
import java.io.*;

public class Main{
    public static int n, m, h;
    public static int[][] map;
    
    public static void dfs(int idx, int depth){
        if(idx == depth){    
            if(check()){    //사다리 완성인지 확인
                System.out.println(depth);
                System.exit(0);
            }
            return;
        }
        
        for(int i = 0; i<h; i++){
            for(int j = 1; j<n; j++){
                //현재위치, 왼쪽, 오른쪽 확인
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
                if(map[x][y]==1){    //현재 위치가 사다리면 오른쪽
                    y++;
                }else if(map[x][y-1]==1){    //왼쪽이 사다리면 왼쪽으로
                    y--;
                }
                //아래로 하강
                x++;
            }
            
            if(y != i){    //하나라도 안 되면 false
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
        System.out.println(-1);    //초과할 경우 혹은 불가능한 경우
    }
}