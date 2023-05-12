import java.util.*;

class Solution {
    public int solution(int[] topping) {
        //topping의 개수가 n이면 n-1만큼 잘라서 확인
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int t : topping){
            if(!map.containsKey(t)){
                map.put(t, 1);
            }else{
                map.put(t, map.get(t) + 1);
            }
        }
        
        
        int count = 0;
        
        for(int i = 0; i<topping.length; i++){
            set.add(topping[i]);
            
            if(map.containsKey(topping[i])){
                int temp = map.get(topping[i]);
                if(temp-1 == 0)
                    map.remove(topping[i]);
                else
                    map.put(topping[i], temp-1);
            }
            
            if(set.size() == map.size())
                count++;
        }
        
        return count;
    }
}