package n1697;

import java.util.*;

public class Main {
    private static int n, k;

    private static void BFS(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[100001];

        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int i = 0; i<3; i++){
                int next;

                if(i==0) next = x-1;
                else if(i==1) next = x+1;
                else next = x*2;

                if(next ==k) {
                    System.out.println(visited[x]);
                    return;
                }

                if(next>=0 && next <=100000 && visited[next] == 0){
                    queue.add(next);
                    visited[next] = visited[x] + 1;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if(n>=k)
            System.out.println(n-k);
        else
            BFS(n);
    }
}
