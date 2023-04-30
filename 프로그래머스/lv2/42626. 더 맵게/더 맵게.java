import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int count = 0;
        
        PriorityQueue<Integer> scovi = new PriorityQueue<>();
        
        for(int i : scoville)
            scovi.add(i);
        
        
        while(scovi.peek()< K){
            
            if(scovi.size() <= 1) {
                return -1;
            }
            
            int x = scovi.poll() + scovi.poll()*2;
            scovi.add(x);
            count++;
        }
        
        return count;
    }
}