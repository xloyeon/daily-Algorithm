import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();
    
    public static boolean check(int x, int y, int idx){
        int c1 = map[x][y];
        
        for(int i = x; i<x+idx; i++){
            for(int j = y; j<y+idx; j++){
                if(map[i][j] != c1)
                    return false;
            }
        }
        return true;
    }
    
    public static void QuadTree(int x, int y, int idx){
        if(check(x, y, idx)){
            sb.append(map[x][y]);
            return;
        }
            
        
        //압축이 안 되는 경우
        int newIdx = idx/2;
        sb.append('(');
        
        QuadTree(x, y, newIdx);
        QuadTree(x, y+newIdx, newIdx);
        QuadTree(x+newIdx, y, newIdx);
        QuadTree(x+newIdx, y+newIdx, newIdx);
        sb.append(')');
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            
            for(int j = 0; j<N; j++){
                map[i][j] = s.charAt(j) -'0';
            }
        }
        
        QuadTree(0, 0, N);
        System.out.println(sb);
    }
}