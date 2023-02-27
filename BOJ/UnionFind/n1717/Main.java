package BOJ.UnionFind.n1717;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return;

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int num){
        if(parent[num] == num) return num;
        else return parent[num] = find(parent[num]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 0; i<n+1; i++)
            parent[i] = i;

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(operation == 0) union(a, b);
            else{
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
