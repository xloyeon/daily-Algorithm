import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    static int[][] map;
    static int total = 0;
    static int min = Integer.MAX_VALUE;
    
    public static void splitPeople(int x, int y, int d1, int d2){
        boolean[][] border = new boolean[N][N];
        
        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] people = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) 
                    break;
                people[0] += map[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j]) 
                    break;
                people[1] += map[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                people[2] += map[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                people[3] += map[i][j];
            }
        }

        // 5 구역 인구수는 모든 구역에서 나머지 인구수 빼면 됨
        people[4] = total;

        for (int i = 0; i < 4; i++) {
            people[4] -= people[i];
        }

        // 정렬
        Arrays.sort(people);
        min = Math.min(min, people[4] - people[0]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int d1 = 1; d1<N; d1++){
                    for (int d2 = 1; d2 < N; d2++) {
                        if (i + d1 + d2 >= N) continue;
                        if (j - d1 < 0 || j + d2 >= N) continue;

                        splitPeople(i, j, d1, d2);
                    }
                }
            }
        }
        
        System.out.println(min);
    }
}