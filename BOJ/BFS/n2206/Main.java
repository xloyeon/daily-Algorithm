package BOJ.BFS.n2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, min;
    static int[][] map;
    static int[][] distance;
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void dfs(int count){
        if(count == 2) {
            bfs();
            if(distance[n-1][m-1] >0) min = Math.min(min, distance[n-1][m-1]);
            return;
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(map[j][i] == 1) {
                    map[j][i] = 0;
                    dfs(count+1);
                    map[j][i] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i<4; i++){
                int tempX = currentX + moveX[i];
                int tempY = currentY + moveY[i];

                if(tempX>=0 && tempY>=0 && tempX<=n-1 && tempY<=m-1){
                    if(map[tempX][tempY] == 0){
                        q.add(new int[]{tempX, tempY});
                        distance[tempX][tempY] = distance[currentX][currentY] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i =0; i<m; i++){
            String s = br.readLine();
            for(int j = 0; j<n; j++){
                map[j][i] = s.charAt(j)-'0';
            }
        }
        distance = new int[n][m];
        bfs();

//        distance = new int[n][m];
//        bfs();
//        int min = 0;
//        if(distance[n-1][m-1]>0){
//            min = distance[n-1][m-1];
//        }else{
//            min = Integer.MAX_VALUE;
//        }
//
//        for(int i = 0; i<m; i++){
//            for(int j = 0; j<n; j++){
//                if(map[j][i] == 1 && !(j==0  && i == 0)){
//                    distance = new int[n][m];
//                    map[j][i] = 0;
//                    bfs();
//
//                    if(distance[n-1][m-1]>0) {
//                        min = Math.min(min, distance[n - 1][m - 1]);
//                    }
//                    map[j][i] = 1;
//                }
//            }
//        }

//        if(min == Integer.MAX_VALUE)
//            System.out.println(-1);
//        else
//            System.out.println(min);
        System.out.println(distance[n-1][m-1]);
    }
}
