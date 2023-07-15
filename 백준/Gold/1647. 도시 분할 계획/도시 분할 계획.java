import java.util.*;
import java.io.*;

public class Main {
    public static int[] parent;
    
    public static int kruskal(int[][] graph){
        int cost = 0;
        int temp = 0;
        
        for(int i = 0; i<graph.length; i++){
            if(find(graph[i][0]) != find(graph[i][1])){
                cost += graph[i][2];
                temp = graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        
        return cost - temp;
    }
    
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x<y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    
    public static void main(String[] args) throws Exception {
        //두 개의 마을로 분리하고, 나머지 길의 유지비 합을 최소로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[m][3];
        
        for(int i = 0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(graph, (o1, o2) ->{
            return o1[2]-o2[2];
        });
        
        parent = new int[n+1];
        
        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }
        
        System.out.println(kruskal(graph));
    }
}