import java.io.*;
import java.util.*;

public class Main {
    public static int n, l, r;
    public static int[][] map;
    public static boolean[][] visited;
    public static List<int[]> countries;
    public static int[] moveX = new int[]{1, -1, 0, 0};
    public static int[] moveY = new int[]{0, 0, 1, -1};
    
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        int people = map[x][y];
        countries = new ArrayList<>();
        countries.add(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            for(int i = 0; i<4; i++){
                int movedX = temp[0] + moveX[i];
                int movedY = temp[1] + moveY[i];
                
                if(movedX>=0 && movedX<n && movedY>=0 && movedY<n){
                    if(!visited[movedX][movedY]){
                        int diff = Math.abs(map[temp[0]][temp[1]] - map[movedX][movedY]);
                        if(diff>= l && diff<=r) {
                            visited[movedX][movedY] = true;
                            q.add(new int[]{movedX, movedY});
                            countries.add(new int[]{movedX, movedY});
                            people += map[movedX][movedY];
                        }
                    }
                }
            }
        }
        
        int newCount = people/countries.size();
        
        for(int i = 0; i<countries.size(); i++){
            int a = countries.get(i)[0];
            int b = countries.get(i)[1];
            map[a][b] = newCount;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
        
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int days = 0;
        
        while(true){
            boolean flag = false;
            visited = new boolean[n][n];
            
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(!visited[i][j]){
                        bfs(i, j);
                        if(countries.size()>=2)
                            flag = true;
                    }
                }
            }
            
            if(!flag)
                break;
            
            days++;
        }
        
        System.out.println(days);
    }
}