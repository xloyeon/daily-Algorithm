import java.util.*;

class Solution {
    public int[][] map;
    
    public int bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        
        q.add(k);
        visited[k] = 1;
        int count = 1; //노드 개수
        
        while(!q.isEmpty()){
            int x = q.poll();
            
            for(int i = 1; i<=n; i++){
                //연결된 방문하지 않은 노드 카운트
                if(map[x][i] == 1 && visited[i] == 0){
                    q.add(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }
        
        //전체에서 카운트값 빼면 됨
        return Math.abs(n - 2*count);
    }
    public int solution(int n, int[][] wires) {
        //최대한 비슷하게 -> 두 전력망이 갖는 송전탑 개수의 차(절대값)가 가장 작을 때
        int count = n;
        
        //a와 b가 연결되어 있으면 map[a][b] = 1, map[b][a] = 1;
        map = new int[n+1][n+1];
        
        //연결 여부 저장
        for(int i = 0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }
            
        //배열 원소 중 하나가 없다고 생각?
        for(int i = 0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            //없는것처럼
            map[a][b] = 0;
            map[b][a] = 0;
            
            count = Math.min(count, bfs(n, i+1));
            
            //되돌려놓기
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        return count;
    }
}