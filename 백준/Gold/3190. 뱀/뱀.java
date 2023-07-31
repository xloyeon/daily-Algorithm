import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map;
    public static Map<Integer, String> move;
    
    public static int[] moveX = {1, 0, -1, 0};
    public static int[] moveY = {0, 1, 0, -1};
    
    public static int n, k;
    
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int time = 0;
        int x = 0;
        int y = 0;
        int idx = 0;
        
        while(true) {
            int movedX = x + moveX[idx];
            int movedY = y + moveY[idx];
            time++;
            
            //범위 벗어나면
            if(movedX<0 || movedY <0 || movedX>n-1 || movedY>n-1) {
                break;
            }
            
            //이미 존재하는 칸
            if(q.contains(movedY*n + movedX)){
                break;
            }
            
            //존재하지 않으면 이동
            if(map[movedY][movedX] == 1) {
                map[movedY][movedX] = 0;
                q.add(movedY*n + movedX);
            }else {
                q.add(movedY*n + movedX);
                q.poll();
            }
            
            if(move.containsKey(time)) {
                String s = move.get(time);
                
                if(s.equals("D")){
                    idx += 1;
                    if(idx == 4) idx = 0;
                }else{
                    idx -=1;
                    if(idx == -1) idx = 3;
                }
            }
            x = movedX;
            y = movedY;
        }
        System.out.println(time);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        move = new HashMap<>();
        
        for(int i = 0; i<k; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
        }
        
        int l = Integer.parseInt(br.readLine());
        
        for(int i =0; i<l; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            move.put(time, s);
        }
        
        bfs();
    }
}