class Solution {
    
    public int[] solution(int n, int s) {
        //만약, n이 s로 나누어진다면 -> n/s를 s번 제곱함
        //만약, n이 s로 나누어지지 않는다면 -> 9를 4개의 수로 나눔 -> 2, 2, 2, 3
        int idx = n;
        int[] result = new int[n];
        int[] none = {-1};
        
        while(idx>0){
            int k = s/idx;
            
            if(k == 0) return none;
            
            result[n-idx] = k;
            s -= result[n-idx];
            idx--;
        }
        return result;
    }
}