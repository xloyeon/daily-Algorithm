package BOJ.BackTracking.n15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Integer> result = new ArrayList<>();
    static boolean[] visited;

    public static void backTracking(int k){
        if(k== m){
            for(Integer i : result)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                result.add(i);
                visited[i] = true;
                backTracking(k+1);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        backTracking(0);
    }
}
