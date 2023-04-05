class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] min = new int[N][N];
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(i==j) min[i][j] = 0;
                else min[i][j] = 1000001;
            }
        }
        
        for(int[] r : road){
            int a = r[0]-1; 
            int b = r[1]-1; 
            int distance = r[2];
            min[a][b] = Math.min(distance, min[a][b]);
            min[b][a] = min[a][b];
            
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    for(int k = 0; k<N; k++){
                        min[j][k] = Math.min(min[j][k], min[j][i] + min[i][k]);
                    }
                }
            }
            
        }
        
        int count = 0;
        
        for(int i = 0; i<N; i++){
            if(min[0][i] <=K){
                count++;
            }
        }
        
        return count;
    }
}