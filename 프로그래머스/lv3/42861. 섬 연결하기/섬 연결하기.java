import java.util.*;

class Solution {
    public int[] parent;
    
    public int union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return x;
        
        if(x<=y)
            return parent[y] = x;
        else
            return parent[x] = y;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        else 
            return parent[x] = find(parent[x]);
    }
    
    public int solution(int n, int[][] costs) {
        //비용 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2]-o2[2];
        });
        
        parent = new int[n];
        
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        
        int result = 0;
        
        for(int i = 0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]);
                result += costs[i][2];
            }
        }
        return result;
    }
}