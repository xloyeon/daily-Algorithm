import java.util.*;
import java.io.*;

class Virus {
    int x;
    int y;
    int time;
    
    public Virus(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    public static int N, M;
    public static int empty;
    public static int min = Integer.MAX_VALUE;
    public static int[][] map;
    public static int[] dX = {-1, 1, 0, 0};
    public static int[] dY= {0, 0, -1, 1};
    public static List<Virus> virus = new ArrayList<>();    //바이러스들
    public static Virus[] active;
    
    public static void dfs(int idx, int count){
        if(count == M){
            spreadVirus(empty);
            return;
        }
        
        for(int i = idx; i<virus.size(); i++){
            active[count] = virus.get(i);
            dfs(i+1, count+1);
        }
    }
    
    public static void spreadVirus(int e){
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        //고른 m개를 넣음
        for(int i = 0; i<M; i++){
            Virus virus = active[i];
            visited[virus.x][virus.y] = true;
            q.add(virus);
        }
        
        while(!q.isEmpty()){
            Virus temp = q.poll();
            
            for(int i = 0; i<4; i++){
                int movedX = temp.x + dX[i];
                int movedY = temp.y + dY[i];
                
                if(movedX>=0 && movedX<N && movedY>=0 && movedY<N) {
                    if(!visited[movedX][movedY]){
                        if(map[movedX][movedY] == 1)
                            continue;
                        
                        //벽이면 빈 공간 하나 줄이기
                        if(map[movedX][movedY] == 0)
                            e--;
                        
                        //빈공간이 0이 되었는지 확인
                        if(e == 0){
                            min = Math.min(min, temp.time+1);
                            return;
                        }
                        
                        visited[movedX][movedY] = true;
                        q.add(new Virus(movedX, movedY, temp.time+1));
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        active = new Virus[M];    //선택할 바이러스들
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 2)
                    virus.add(new Virus(i, j, 0));
                else if(map[i][j] == 0)
                    empty++;
            }
        }
        
        if(empty == 0) {
            System.out.println(0);
            
        }else {
            //M개의 바이러스를 활성 상태로 변경 -> 선택
            dfs(0, 0);
        
            if(min == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(min); 
        }
    }
}