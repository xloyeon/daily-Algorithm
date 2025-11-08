import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int[][] dp = new int[len + 1][m];
        
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0; // 아무것도 안 훔쳤을 때

        for (int i = 1; i <= len; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for (int j = 0; j < m; j++) {
                // 불가능한 경우
                if (dp[i - 1][j] == Integer.MAX_VALUE) 
                    continue;

                // A가 훔치는 경우
                if (dp[i - 1][j] + a < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                }

                // B가 훔치는 경우
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[len][j]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
