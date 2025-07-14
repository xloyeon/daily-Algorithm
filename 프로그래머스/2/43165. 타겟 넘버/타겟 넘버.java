import java.util.*;

class Solution {
    public int result = 0;
    public int[] numbers;
    public int target;
    
    public void dfs(int idx, int sum){
        if(idx == numbers.length){
            if(sum == target)
                result++;
            return;
        }
        
        dfs(idx+1, sum - numbers[idx]);
        dfs(idx+1, sum + numbers[idx]);
    }    
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(1, 0 - numbers[0]);
        dfs(1, 0 + numbers[0]);
        
        return result;
    }
}