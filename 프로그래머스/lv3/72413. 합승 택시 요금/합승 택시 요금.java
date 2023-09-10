import java.util.*;

class Solution {
    public int[][] costs;
    
    public int[] findMinCost(int start, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0]-o2[0];
        });
        
        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        result[start] = 0;
        pq.add(new int[]{0, start});
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int from = temp[1];
            
            if(visited[from]) continue;
            
            visited[from] = true;
            
            for(int i = 1; i<=n; i++){
                if(costs[from][i] == 0)
                    continue;
                
                if(result[from] + costs[from][i] < result[i]){
                    result[i] = result[from] + costs[from][i];
                    pq.add(new int[]{result[i], i});
                }
            }
            
            
        }
        
        return result;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //각자 이동하거나(s->a, s->b)
        //중간지점까지 타고 가서 따로 이동(s->c, c->a, c->b)
        //다익스트라
        
        costs = new int[n+1][n+1];
        
        for(int i = 0; i<fares.length; i++){
            int x = fares[i][0];
            int y = fares[i][1];
            costs[x][y] = fares[i][2];
            costs[y][x] = fares[i][2];
        }
        
        int[] start = findMinCost(s, n);
        int[] startA = findMinCost(a, n);
        int[] startB = findMinCost(b, n);
        
        int answer = Integer.MAX_VALUE;
        
        for(int i =1; i<=n; i++){
            answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        }
        return answer;
    }
}