class Solution {
    public int[] memo;
    
    public int dp(int n){
        if(n  <= 1){
            return 1;
        }
        
        if(memo[n] !=0) return memo[n];
        
        return memo[n] = (dp(n-1) + dp(n-2)) % 1000000007;
    }
    
    public int solution(int n) {
        //세로 길이가 1, 가로 길이가 2인 타일 이용
        //채우려는 공간 -> 세로 길이 2, 가로 길이 n
        //경우의 수를 1000000007로 나눈 나머지 -> dp
        
        //dp(1) = 1, dp(2) = dp(1) + 1 = 2 , dp(3) = dp(2) + dp(1) = 3, 
        //dp(4) = dp(3) + dp(2) = 5, dp(5) = dp(4)  + dp(3)
        memo = new int[n+1];
        return dp(n);
    }
}