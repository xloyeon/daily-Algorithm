package n13549;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int n, k;

    private static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        int min = 100001;

        q.offer(n);
        visited[n] = 1;

        while(!q.isEmpty()){
            int x = q.poll();

            if(x==k){
               System.out.println(visited[x]-1);
            }

            int next = -1;
            for(int i = 0; i<3; i++){
                if(i==0) next = 2*x;
                if(i==1) next = x-1;
                if(i==2) next = x+1;

                if(next>=0 && next<=100000 && visited[next] ==0){
                    q.offer(next);
                    if(i==0){
                        visited[next] = visited[x];
                    }else{
                        visited[next] = visited[x] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if(n>=k){
            System.out.println(n-k);
        }else{
            BFS();
        }
    }
}
