class Solution {
    public int mod = 1000000007;
    
    public int solution(int n) {
        //홀수일 때 -> 불가능
        //짝수일 때 -> 2개씩 늘어나므로 -> (n-2의 경우의 수)*3
        //짝수일 때 -> 중간에 겹치는 부분 -> 2일때 0
        //4일때 2, 
        //6일 때 (n-2일때 겹치는 부분)*2 +2 = 6
        //8일 때 (n-2일 때 겹치는 부분)*2 + (n-4일때 겹치는 부분)*2 + 2 
        
        long[] arr= new long[n+1];  //arr[i] = 가로 i인 직사각형 채우는 방법의 수
        
        arr[0] = 1;
        arr[2] = 3;
        
        for(int i = 4; i<=n; i+=2){
            arr[i] = arr[i-2]*3;
            
            for(int j = i-4; j>=0; j-=2){
                arr[i] += (arr[j]*2);
            }
            arr[i] = arr[i]%mod;
        }
        
        return (int)(arr[n]);
    }
}