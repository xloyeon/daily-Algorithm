import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map = new int[101][101];
    public static int[] moveX = {1, 0, -1, 0};
    public static int[] moveY = {0, -1, 0, 1};
    
    public static void dragon(int x, int y, int d, int g){
        List<Integer> dragonList = new ArrayList<>();
        
        dragonList.add(d);
        
        for(int i = 1; i<=g; i++){
            for(int j = dragonList.size()-1; j>=0; j--){
                dragonList.add((dragonList.get(j)+1)%4);
            }
        }
        
        map[y][x] = 1;
        
        for(Integer dra : dragonList){
            x += moveX[dra];
            y+= moveY[dra];
            map[y][x] = 1;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); 
            int g = Integer.parseInt(st.nextToken());
            
            dragon(x, y, d, g);
        }
        
        int result = 0;
        
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(map[i][j] == 1 && map[i][j+1] == 1 &&
                  map[i+1][j] == 1 && map[i+1][j+1] == 1){
                    result++;
                }
            }
        }
        
        System.out.println(result);
    }
}