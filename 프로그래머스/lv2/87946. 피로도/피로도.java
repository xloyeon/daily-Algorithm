class Solution {
    public boolean[] visited;
    
    public int maxDungeons(int k, int[][] dungeons){
        int count = 0;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                count = Math.max(count, maxDungeons(k - dungeons[i][1], dungeons));
                visited[i] = false;
            }
        }

        return Math.max(count, countDungeons());
        
    }
    
    private int countDungeons() {
        int count = 0;
        for (boolean v : visited) {
            if (v)
                count++;
        }
        return count;
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        return maxDungeons(k, dungeons);
    }
}