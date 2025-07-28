import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        //입력값
        // 1. 도시의 수 : N   (200이하)
        // 2. 여행 게획에 속한 도시들 수 : M (1000 이하)
        // 3. N개의 줄에 N개의 정수
        // 4. 마지막 줄 -> 여행 게획

        // 경유해서 도시를 가기만 하면 되므로 .. 길이 있는지만 확인하면 됨 -> 전형적인 집합 문제 >> Union-find
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //노드 수
        int M = Integer.parseInt(st.nextToken());   //간선 수

        int[][] edges = new int[M][3];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        //초기화
        long[] dist = new long[N+1];
        for(int i = 1; i<N+1; i++){
            dist[i] = Long.MAX_VALUE;
        }

        dist[1] = 0;

        //N-1번 반복하면 최단경로 찾을 수 있음
        for(int i = 1; i<=N-1; i++) {

            for(int[] edge : edges){
                int a = edge[0];
                int b = edge[1];
                int c = edge[2];
                if(dist[a] != Long.MAX_VALUE && dist[a] + c <dist[b] ){
                    dist[b] = dist[a] + c;
                }
            }
        }

        boolean flag = false;

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];

            if(dist[a] != Long.MAX_VALUE && dist[a] + c < dist[b]) {
                flag = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(flag){
            sb.append("-1");
        }else{
            for(int i = 1; i<=N; i++){
                if(i == 1) continue;

                if(dist[i] == Long.MAX_VALUE)
                    sb.append("-1").append("\n");
                else
                    sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}