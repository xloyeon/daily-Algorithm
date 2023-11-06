import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static int[][][] dp;
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        dp = new int[N][M][3];
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        for(int i = 0; i<M; i++){
            for(int j = 0; j<3; j++){
                dp[0][i][j] = map[0][i];
            }
        }
        
        
        for(int i = 1; i<N; i++){
            for(int j = 0; j<M; j++){
                if(j == 0) {    //위, 오른쪽 대각선만 가능
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + map[i][j];
                }else if(j == M-1) {
                    dp[i][j][1] = dp[i-1][j][2] + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + map[i][j];
                }else {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j];
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<M; i++){
            for(int j = 0; j<3; j++){
                result = Math.min(result, dp[N-1][i][j]);
            }
        }
        
        System.out.println(result);
    }
}