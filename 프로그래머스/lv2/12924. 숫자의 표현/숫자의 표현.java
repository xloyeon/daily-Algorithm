class Solution {
    public int solution(int n) {
        int[] sums = new int[n];
        sums[0] = 1;
        
        for(int i = 1; i<n; i++){
            sums[i] = sums[i-1] + i+1;
        }
        
        int count = 0;
        int start = 0;
        
        for(int i = 0; i<sums.length; i++){
            if(sums[i]<n) continue;
            
            if(sums[i] == n) {
                count++;
                continue;
            }
            
            while(start<i){
                if(sums[i]-sums[start] > n){
                    start++;
                }else if(sums[i]- sums[start]==n){
                    start++;
                    count++;
                    break;
                }else{
                    break;
                }
            }
        }
        
        return count;
    }
}