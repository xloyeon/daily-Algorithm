package BOJ.BFS.n14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int max = 0;
    static int[][] map;
    static int[] addX = {1, 0, 0, -1};
    static int[] addY = {0, 1, -1, 0};

    public static void dfs(int count){
        if(count == 3) {
            bfs(map);
            return;
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(map[j][i] == 0) {
                    map[j][i] = 1;
                    dfs(count+1);
                    map[j][i] = 0;
                }
            }
        }
    }

    public static void bfs(int[][] map){
        int[][] copyMap = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++) {
                copyMap[j][i] = map[j][i];
                if(copyMap[j][i] == 2)
                    q.add(new int[]{j, i});
            }
        }

        while(!q.isEmpty()) {
            int[] virus = q.poll();
            int virusX = virus[0];
            int virusY = virus[1];

            for(int i = 0; i<4; i++){
                int tempX = virusX + addX[i];
                int tempY = virusY + addY[i];

                if(tempX>=0 && tempY>=0 && tempX<=n-1 && tempY<=m-1){
                    if(copyMap[tempX][tempY] == 0){
                        copyMap[tempX][tempY] = 2;
                        q.add(new int[]{tempX, tempY});
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(copyMap[j][i] == 0)
                    count++;
            }
        }

        max = Math.max(max, count);

    }


    public static void main(String[] args) throws IOException{
        //n, m 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //n,m만큼의 배열 생성
        map = new int[n][m];

        //nxm 배열 저장
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++ ){
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);

        /* dfs 탐색
        - 0이 있는 자리 모두 저장 or 찾기
        - 0이 있는 자리 탐색
        - 마지막 세 자리 골라지면 벽 세우고 안전영역 넓이 구하기
        */

        /*bfs 바이러스
        - 큐 이용
        - 처음 위치 큐에 넣고 큐가 빌 때까지 반복
        - x위치 배열, y위치 배열 만들어 놓고
        - 4번 돌면서, i번째 index 합친 걸로 계산
        - 자리가 0이면 2로 바꾸고, 1, 2면 그대로
        - 큐가 빌 때까지 반복한 뒤 return
         */

        /*안전영역 넓이 계산
        배열에서 0의 개수 구해서 다 더하기
        만약, max보다 크면 max를 갱신
         */


    }
}
