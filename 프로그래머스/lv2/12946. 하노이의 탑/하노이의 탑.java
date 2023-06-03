import java.util.*;

class Solution {
    public List<int[]> resultList;
    
    public void dfs(int n, int start, int to, int mid) {
        if(n == 1){
            resultList.add(new int[]{start, to});  //start에서 to로 바로 옮김
            return;
        }
        
        // n-1개를 mid로 이동
        dfs(n-1, start, mid, to);

        // 남은 하나를 start에서 to로 바로 이동
        resultList.add(new int[]{start, to});

        // 옮겼던 n-1개를 end로 이동
        dfs(n-1, mid, to, start);
    }
    
    public int[][] solution(int n) {
        //하노이의 탑은 한 원판을 mid를 거쳐 end로 이동시킴
        resultList = new ArrayList<>();
        dfs(n, 1, 3, 2);    //n개를 1에서 3으로 2를 거쳐 이동
        
        int[][] result = new int[resultList.size()][2];
        
        for(int i = 0; i<resultList.size(); i++){
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        
        return result;
    }
}