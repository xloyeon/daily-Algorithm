class Solution {
    
    public int solution(int[] money) {
        //인접한 두 집을 털 순 없으니 .. 최대로 털 수 있는 집은?
        //n번째 집을 털었다고 하면 .. n-1번째 집을 털 순 없음
        //n번째 또는 n-1번째 집 중 하나만 털 수 있음!
        
        //첫째집을 터는 경우 -> dp1, 첫째집을 털지 않는 경우 -> dp2
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        
        dp1[0] = money[0];
        dp1[1] = money[0]; 
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i<money.length; i++){
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        
        return Math.max(dp2[money.length-1], dp1[money.length-2]);
        
    }
}