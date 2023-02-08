package BruteForce.BruteForce_recursion.n16198;

import java.util.Scanner;

public class Main {
    static int max = 0;
    static int[] balls;
    static boolean[] visited;

    private static void recursion(int num, int energy){
        if(num == 2){
            max = Math.max(max, energy);
            return;
        }

        for(int i = 1; i<balls.length-1; i++){
            if(visited[i]) continue;

            visited[i] = true;

            int prev = i-1;
            int next = i+1;
            while(visited[prev]){
                prev--;
            }

            while(visited[next])
                next++;

            int e= balls[prev] * balls[next];

            recursion(num-1, energy + e);
            visited[i] = false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        balls = new int[n];
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            balls[i] = sc.nextInt();
        }

        recursion(n, 0);

        System.out.println(max);
    }
}
