import java.util.*;
import java.io.*;


public class Main {
    public static int[] parent;
    
    public static long kruskal(int[][] graph){
        long cost = 0;
        
        for(int i = 0; i<graph.length; i++){
            if(find(graph[i][0]) != find(graph[i][1])){
                cost += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        
        return cost;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[e][3];
        
        for(int i = 0; i<graph.length; i++){
            st = new StringTokenizer(br.readLine());
            
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(graph, (o1, o2) -> {
            return o1[2]-o2[2];
        });
        
        parent = new int[v+1];
        
        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }
        
        System.out.println(kruskal(graph));
    }
}