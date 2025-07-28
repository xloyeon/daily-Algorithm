import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] edges = new int[2*M+W][3];
            int idx = 0;

            for(int j = 0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges[idx][0] = a;
                edges[idx][1] = b;
                edges[idx][2] = c;
                idx++;

                edges[idx][0] = b;
                edges[idx][1] = a;
                edges[idx][2] = c;
                idx++;
            }

            for(int j = 0; j<W; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = (-1) * Integer.parseInt(st.nextToken());
                edges[idx][0] = a;
                edges[idx][1] = b;
                edges[idx][2] = c;
                idx++;
            }

            int[] dist = new int[N+1];

            for(int j = 1; j<=N-1; j++){
                for(int[] edge : edges){
                    int a = edge[0];
                    int b = edge[1];
                    int c = edge[2];

                    if(dist[a] + c < dist[b])
                        dist[b] = dist[a] + c;
                }
            }

            boolean checkMinus = false;

            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                int c = edge[2];

                if (dist[a] + c < dist[b]) {
                    dist[b] = dist[a] + c;
                    checkMinus = true;
                }
            }

            if(checkMinus) {
                sb.append("YES").append("\n");
            }else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}