import java.util.*;
import java.io.*;


class Edge implements Comparable<Edge>{
    int a;
    int b;
    double w;
    
    public Edge(int a, int b, double w){
        this.a = a;
        this.b = b;
        this.w = w;
    }
    
    public int compareTo(Edge e){
        if(this.w > e.w) return 1;
        return -1;
    }
}

public class Main {
    public static int[] parent;
    
    public static void kruskal(List<Edge> edges){
        double cost = 0;
        
        for(int i = 0; i<edges.size(); i++){
            Edge edge = edges.get(i);
            
            if(find(edge.a) != find(edge.b)){
                cost += edge.w;
                union(edge.a, edge.b);
            }
        }
        
        System.out.println(String.format("%.2f", cost));
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
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n+1][2];
        List<Edge> edges = new ArrayList<>();
        
        //부모 배열 만들기
        parent = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        
        //점들 좌표 저장
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
       
        //이미 연결되어있는 것들 합집합 연산
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        
        for(int i = 1; i<n; i++){
            for(int j = i+1; j<=n; j++){
                double distance = Math.pow(map[i][0]-map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2);
                distance = Math.sqrt(distance);
                edges.add(new Edge(i, j, distance));
            } 
        }
        
        Collections.sort(edges);
        
        kruskal(edges);
    }
}