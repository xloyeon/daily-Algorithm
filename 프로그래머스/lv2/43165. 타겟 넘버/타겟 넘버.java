import java.util.*;

class Solution {

    public int solution(int[] numbers, int target) {
        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, numbers[0]});
        q.add(new int[]{0, -numbers[0]});
        
        while(!q.isEmpty()){
            int[] x = q.poll();
            
            if(x[0] == numbers.length-1 && x[1] == target){
                count++;
                continue;
            }
            
            int idx = x[0] + 1;
            
            if(idx < numbers.length){
                q.add(new int[]{idx, x[1]+numbers[idx]});
                q.add(new int[]{idx, x[1]-numbers[idx]});
            }
        }
        
        return count;
    }
}