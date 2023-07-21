import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int ans = dfs(begin, target, words, visited, 1, Integer.MAX_VALUE);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private int dfs(String begin, String target, String[] words, boolean[] visited, int cnt, int ans) {
        if (begin.equals(target)) {
            return cnt - 1;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && onlyOneDifferentChar(begin, words[i])) {
                visited[i] = true;
                ans = Math.min(ans, dfs(words[i], target, words, visited, cnt + 1, ans));
                visited[i] = false;
            }
        }
        return ans;
    }

    private boolean onlyOneDifferentChar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int differentCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }
}