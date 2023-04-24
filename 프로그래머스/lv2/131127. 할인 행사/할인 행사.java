import java.util.*;

class Solution {
    public String[] want;
    public int[] number;
    public String[] discount;
    
    public boolean isSuccess(int i){
        Map<String, Integer> map = new HashMap<>();
        
        for(int j = 0; j<want.length; j++){
            map.put(want[j], number[j]);
        }
            
        for(int j = 0; j<10; j++){
            if(map.containsKey(discount[i+j]) && map.get(discount[i+j])>0){
                map.put(discount[i+j], map.get(discount[i+j])-1);
            }
        }
            
        for(int j = 0; j<want.length; j++){
            if(map.containsKey(want[i]) && map.get(want[i])!=0)
                return false;
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        
        for(int i = 0; i<=discount.length-10; i++){
            Map<String, Integer> map = new HashMap<>();
        
            for(int j = 0; j<want.length; j++){
                map.put(want[j], number[j]);
            }
            
            for(int j = 0; j<10; j++){
                if(map.containsKey(discount[i+j]) && map.get(discount[i+j])>0){
                    map.put(discount[i+j], map.get(discount[i+j])-1);
                }
            }
            
            if(isSuccess(want, map)) count++;
        }
        
        return count; 
    }
    
    public boolean isSuccess(String[] want, Map<String, Integer> map){
        for(int j = 0; j<want.length; j++){
            if(map.containsKey(want[j]) && map.get(want[j])!=0)
                return false;
        }
        return true;
    }
}