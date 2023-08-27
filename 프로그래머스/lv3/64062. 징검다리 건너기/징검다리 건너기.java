class Solution {
    
    public boolean check(int mid, int k, int[] stones){
        int count = 0;
        
        for(int i = 0; i<stones.length; i++){
            if(stones[i] < mid){ //건너뛸 수 없는 경우
                count++;
                if(count >=k) return false;
            }else{
                count = 0;
            }
        }
        return true;
    }
    
    public int solution(int[] stones, int k) {
        
        //이분탐색 -> 기준 : 징검다리 건너는 친구 수
        
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while(min<=max){
            int mid = (min + max)/2;
            
            if(check(mid, k, stones)){
                min = mid+1;
                answer = mid;
            }else{
                max = mid-1;
            }
        }
        return answer;
        
    }
}