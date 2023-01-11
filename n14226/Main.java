package n14226;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int s;
    private static int[][] visited;

    private static void BFS(int start, int s){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start, 0});
        visited[start][0] = 1;

        while(!q.isEmpty()){
            int[] x = q.poll();
            int idx = x[0];
            int copy = x[1];

            if(idx==s){
                System.out.println(visited[idx][copy]-1);
                return;
            }

            int next = idx;
            int temp = copy;

            for(int i = 0; i<3; i++){
                if(i==0 && idx>0)
                    temp = idx;
                if(i==1 && copy>0) {
                    next = idx + copy;
                    temp = copy;
                }

                if(i==2 && idx>=1 && copy>0) {
                    next = idx-1;
                    temp = copy;
                }

                if(next>=0 && next<visited.length && visited[next][temp]==0){
                    visited[next][temp] = visited[idx][copy]+1;
                    q.offer(new int[]{next, temp});
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        visited = new int[2*s+1][2*s+1];
        BFS(1, s);
    }
}
