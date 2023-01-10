package n13913;

import java.util.*;

public class Main {
    private static int[] visited = new int[100001];
    private static int[] parent = new int[100001];

    private static void BFS(int start, int k){
        Queue<Integer> q = new LinkedList<Integer>();

        //start>=k일 때
        if(start >= k){
            System.out.println(start-k);
            for(int i = start; i>=k; i--)
                System.out.print(i + " ");
            return;
        }

        //start<k일 때, 시작 정점 큐에 넣고 시간=1
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            if(x==k) {
                printResult(start, k);
                return;
            }

            int next = 0;

            for(int i = 0; i<3; i++){
                if(i==0) next = x-1;
                if(i==1) next = x+1;
                if(i==2) next = x*2;

                if(next>=0 && next<=100000 && visited[next] == 0){
                    q.offer(next);
                    visited[next] = visited[x] + 1;
                    parent[next] = x;
                }
            }
        }

    }

    private static void printResult(int n, int k){
        Stack<Integer> s = new Stack<>();
        int idx = k;

        //k부터 부모 노드를 저장
        while(idx!=n){
            s.push(idx);
            idx = parent[idx];
        }
        //시작 노드 추가
        s.push(idx);

        System.out.println(visited[k]-1);
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        BFS(n, k);
    }
}
