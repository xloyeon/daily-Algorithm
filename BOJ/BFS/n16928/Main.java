package BOJ.BFS.n16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static HashMap<Integer, Integer> ladder;
    private static HashMap<Integer, Integer> snake;

    private static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[101];

        q.offer(1);
        visited[1] = 1;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i = 0; i<6; i++){
                int next = current + i+1;

                if(next>100) continue;

                if(ladder.containsKey(next)){
                    next = ladder.get(next);
                }else if(snake.containsKey(next)){
                    next = snake.get(next);
                }

                if(next == 100){
                    System.out.println(visited[current]);
                    return;
                }

                if(next>=1 && next<100){
                    if(visited[next] ==0 | visited[current]+1<visited[next]){
                        visited[next] = visited[current]+1;
                        q.offer(next);
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ladder = new HashMap<>();
        snake = new HashMap<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder.put(x, y);
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake.put(u, v);
        }

        BFS();
    }
}
