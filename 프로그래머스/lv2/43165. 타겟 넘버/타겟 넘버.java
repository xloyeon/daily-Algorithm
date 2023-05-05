import java.util.*;

class Solution {
    
    //BFS
    public int solution(int[] numbers, int target) {
        int count = 0;
        
        //{numbers의 index, 현재 누적합}
        Queue<int[]> q = new LinkedList<>(); 
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()){
            int[] x = q.poll();
            
            if(x[0]>=numbers.length && x[1] == target)
                count++;
            
            if(x[0]>=0 && x[0]<numbers.length){
                q.add(new int[]{x[0]+1, x[1]+numbers[x[0]]});
                q.add(new int[]{x[0]+1, x[1]-numbers[x[0]]});
            }
        }
        return count;
    }
}