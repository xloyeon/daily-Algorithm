import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i<=elements.length; i++){
            
            for(int j = 0; j<elements.length; j++){
                int temp = 0;
                int count = 0;
                
                for(int k = j; k<elements.length; k++){
                    temp += elements[k];
                    count++;
                    
                    if(count == i) break;
                    
                    if(k==elements.length-1){
                        k = -1;
                    }
                }
                set.add(temp);
            }
        }
        
        return set.size();
    }
}