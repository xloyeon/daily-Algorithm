public class Solution {
    public int N;
    public int[][] map;
    public int[] visited;
    public int[] minHours;

    public int findNearest() {
        int minDist = Integer.MAX_VALUE;
        int idx = -1;
        
        for (int i = 1; i <= N; i++) {
            //방문한 적 없는 노드 중 최소거리인 노드
            if (visited[i] == 0 && minHours[i] < minDist) {
                minDist = minHours[i];
                idx = i;
            }
        }
        return idx;
    }

    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.map = new int[N+1][N+1];
        this.visited = new int[N+1];
        this.minHours = new int[N+1];

        // map 초기화 (최소 거리만 저장)
        for (int i = 0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            //최소 도로로 저장해야 함
            if (map[a][b] == 0 || map[a][b] > c) {
                map[a][b] = c;
                map[b][a] = c;
            }
        }

        // 최소 거리 최댓값으로 초기화
        for (int i = 1; i <= N; i++) {
            minHours[i] = Integer.MAX_VALUE;
        }
        
        //마을 1 자신까지의 거리는 0
        minHours[1] = 0;

        // 다익스트라 탐색 시작
        for (int i = 1; i <= N; i++) {
            int node = findNearest();
            visited[node] = 1;

            for (int j = 1; j <= N; j++) {
                if (visited[j] == 1) continue;
                if (map[node][j] != 0) {
                    minHours[j] = Math.min(minHours[j], minHours[node] + map[node][j]);
                }
            }
        }

        // K 이하인 마을 카운트
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (minHours[i] <= K) answer++;
        }

        return answer;
    }
}
