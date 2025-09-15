import java.util.*;
import java.io.*;


public class Main {
    public static int N, W;
    public static int[][] cases;
    public static int[][] dispatched;
    public static int[][] memo;

    public static int dp(int a, int b){
        if(Math.max(a, b) == W) return 0;

        int nextCase = Math.max(a, b) + 1;  //다음 사건 번호

        if(memo[a][b] != -1)
            return memo[a][b];

        int x1 = dp(nextCase, b) + getDistance(a, nextCase, 1);
        int x2 = dp(a, nextCase) + getDistance(b, nextCase, 2);

        if(x1<x2){
            memo[a][b] = x1;
            dispatched[a][b] = 1;
        }else{
            memo[a][b] = x2;
            dispatched[a][b] = 2;
        }

        return memo[a][b];
    }


    public static int getDistance(int from, int to, int idx){
        //경찰차 위치
        int x1, y1;

        //초기값 세팅
        if(from == 0){
            if(idx == 1){
                x1 = 1;
                y1 = 1;
            }else{
                x1 = N;
                y1 = N;
            }
        }else{
            x1 = cases[from][0];
            y1 = cases[from][1];
        }

        int x2 = cases[to][0];
        int y2 = cases[to][1];

        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        cases = new int[W+1][2];

        for(int i = 1; i<= W; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cases[i][0] = Integer.parseInt(st.nextToken());
            cases[i][1] = Integer.parseInt(st.nextToken());
        }

        dispatched = new int[W+1][W+1];
        memo = new int[W+1][W+1];

        for(int[] m : memo)
            Arrays.fill(m, -1);

        System.out.println(dp(0, 0));

        int police1 = 0;
        int police2 = 0;

        for(int i = 1; i<=W; i++){
            int p = dispatched[police1][police2];

            System.out.println(p);

            if(p == 1)
                police1 = i;
            else
                police2 = i;
        }

    }
}