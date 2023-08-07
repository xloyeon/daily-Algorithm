class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int start = 1;
        
        //stations는 오름차순 정렬 되어 있음
        for(int i = 0; i<stations.length; i++) {
            if(start < stations[i] -w) {    //왼쪽 전파 범위 전이면
                int end = stations[i] - w;
                
                int temp = (end-start)/(w*2+1);
                if((end-start)%(w*2+1) != 0)
                    temp ++;
                count += temp;
            }
            start = stations[i] + w + 1;  // 여기서부터 다시 시작
        }
        
        //station의 마지막 전파 범위가 끝이 아니면
        if(start-1 < n){
            int end = n+1;
            
            int temp = (end-start)/(w*2+1);
            if((end-start)%(w*2+1) != 0)
                temp++;
            count+= temp;
        }
        return count;
            
    }
}