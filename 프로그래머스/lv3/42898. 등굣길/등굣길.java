class Solution {
    private final long mod = 1000000007;
    private int[][] map;
    
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n+1][m+1];
        
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }
          
        map[1][1] = 1;
        
        //최단이려면 오른쪽, 왼쪽만 움직이기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //현재 위치가 물이 잠기지 않았으면
                if (map[i][j] != -1) {
                    //왼쪽 확인 -> 갈 수 있으면 +1
                    if (i > 1 && map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j];
                    }
                    //위쪽 확인 -> 갈 수 있으면 +1
                    if (j > 1 && map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1];
                    }
                    
                    map[i][j] %= 1000000007;
                }
            }
        }
        return map[n][m];
    }
}